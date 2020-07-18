package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_sante.adapter.DemandePatient_adapter
import kotlinx.android.synthetic.main.fragment_demande_patient.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Demande_patient : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Afficherdemande()
        return inflater.inflate(R.layout.fragment_demande_patient, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private fun Afficherdemande() {

        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()
        var token : String? = sp.getString("x-auth-token","No x-auth-token")


        val call = token?.let { RetrofitService.endpoint.getAlldemande(it) }
        if (call != null) {
            call.enqueue(object : Callback<List<Demande>> {

                override fun onFailure(call: Call<List<Demande>>, t: Throwable) {
                    spin_kit5.visibility=View.INVISIBLE

                    Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<List<Demande>>, response: Response<List<Demande>>) {
                    spin_kit5.visibility=View.INVISIBLE

                    if(response.isSuccessful){

                        val list= response.body()!!
                        DemandePatient_recyclerview.adapter= activity?.applicationContext?.let {
                            DemandePatient_adapter(
                                it,list) }
                        DemandePatient_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)

                    }else{
                        Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                    }
                }
            })
        }
    }
}