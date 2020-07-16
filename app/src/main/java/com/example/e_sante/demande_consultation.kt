package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_sante.entities.Demande_a_creer
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_demande_consultation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class demande_consultation : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demande_consultation, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



//////recuperation de lid depuis home patient ////////////////
        val id_doctor = arguments?.getInt("id_doctor")

        demandeconsultation_Button_Envoyer.setOnClickListener{
            if (id_doctor != null) {
                Ajouter_Demande(id_doctor)
            }
        }


//////////////////////boutton back
        demandeconsultation_imagebutton_retour.setOnClickListener{
            getActivity()?.onBackPressed()
        }

    }

private fun Ajouter_Demande(id_doctor:Int)
{
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val demande =Demande_a_creer("1346852",demandeconsultation_edittext_symptomes.text.toString(),
        demandeconsultation_editText_traitement.text.toString(),id_doctor)

    val call= token?.let { RetrofitService.endpoint.ajouter_demande(demande, it) }
    if (call != null) {
        call.enqueue(object : Callback<Demande> {
            override fun onFailure(call: Call<Demande>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<Demande>, response: Response<Demande>) {
                if(response.isSuccessful){
                    Toast.makeText(activity?.applicationContext,"Demande ajouté avec succes", Toast.LENGTH_SHORT).show()


                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }
}
}
