package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_sante.entities.Consultation_adapter
import kotlinx.android.synthetic.main.fragment_consultation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Consultation : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AfficherConsultation()
        return inflater.inflate(R.layout.fragment_consultation, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


private fun AfficherConsultation()
{
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")


    val call= token?.let { RetrofitService.endpoint.getAllconsultation(it) }
    if (call != null) {
        call.enqueue(object : Callback<List<Consutation_BD>> {
            override fun onFailure(call: Call<List<Consutation_BD>>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Consutation_BD>>,
                response: Response<List<Consutation_BD>>
            ) {
            if(response.isSuccessful){

                val list= response.body()!!
                consultation_recyclerView.adapter= activity?.applicationContext?.let {
                    Consultation_adapter(
                        it,list) }
                consultation_recyclerView.layoutManager=LinearLayoutManager(activity?.applicationContext)


            }else{
                Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

            }
            }
        })
    }
}
}
