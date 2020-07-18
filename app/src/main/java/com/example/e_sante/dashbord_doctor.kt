package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_sante.entities.Dashbord_BD
import kotlinx.android.synthetic.main.fragment_dashbord_doctor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class dashbord_doctor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        GestDashbord()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashbord_doctor, container, false)
    }



    private fun GestDashbord()
    {
        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()
        var token : String? = sp.getString("x-auth-token","No x-auth-token")

        val call= token?.let { RetrofitService.endpoint.getIndicateurDashbord(it) }
        if (call != null) {
            call.enqueue(object : Callback<Dashbord_BD>{
                override fun onFailure(call: Call<Dashbord_BD>, t: Throwable) {
                    spin_kit20.visibility=View.INVISIBLE
                    Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(call: Call<Dashbord_BD>, response: Response<Dashbord_BD>) {
                    spin_kit20.visibility=View.INVISIBLE
                    if(response.isSuccessful)
                    {
                        val indicateur= response.body()!!

                        dashbord_textView_nbdemande.text=indicateur.demande_jour
                        dashbord_textView_nbdemande123.text= indicateur.evolution.toString()
                        dashbord_textView_nbcas.text=indicateur.demande_jour_traite
                        dashbord_textView_nbcas456.text=indicateur.demande_total



                    }else{
                        Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                    }
                }
            })}




    }
    }


