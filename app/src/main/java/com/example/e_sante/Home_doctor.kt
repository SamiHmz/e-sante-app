package com.example.e_sante

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_sante.adapter.Home_doctor_adapter
import kotlinx.android.synthetic.main.fragment_home_doctor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime


class Home_doctor : Fragment() {


    @RequiresApi(Build.VERSION_CODES.O)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AfficherDemandes()
        return inflater.inflate(R.layout.fragment_home_doctor, container, false)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

private fun AfficherDemandes(){
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")


    val call = token?.let { RetrofitService.endpoint.getAlldemande(it) }
    if (call != null) {
        call.enqueue(object : Callback<List<Demande>> {
            override fun onFailure(call: Call<List<Demande>>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Demande>>, response: Response<List<Demande>>) {
                if(response.isSuccessful){

                    val list= response.body()!!
                    HomeDoctor_recyclerview.adapter= activity?.applicationContext?.let {
                        Home_doctor_adapter(
                            it,list) }
                    HomeDoctor_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)


                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }

        })
}
}

}
