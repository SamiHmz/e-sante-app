package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_sante.entities.Consultation_a_creer
import kotlinx.android.synthetic.main.fragment_traitement_doctor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class traitement_doctor : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_traitement_doctor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


// recuperation de id depuis fragment demande doctor////////////////////////
        val demande_id = arguments?.getInt("demande_id")

//button back///////////////////////////////////////////////////////////////
        traitementDoctor_imageButton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
// button denvoi du consultation //////////////////
        traitementDoctor_button_Envoyer.setOnClickListener{

            if (demande_id != null) {
                Envoyerconsultatiom(demande_id.toInt())
            }
        }

    }


private fun Envoyerconsultatiom(demande_id:Int)
{
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val consultation =Consultation_a_creer(traitementDoctor_edittext_Diagnostique.text.toString(),
        traitementDoctor_edittext_traitement.text.toString(),demande_id)

    val call= token?.let { RetrofitService.endpoint.ajouter_consultation(consultation, it) }
    call?.enqueue(object : Callback<Consutation_BD> {
        override fun onFailure(call: Call<Consutation_BD>, t: Throwable) {
            Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<Consutation_BD>, response: Response<Consutation_BD>) {
            if(response.isSuccessful){

                Toast.makeText(activity?.applicationContext,"Consultation ajouté avec succes", Toast.LENGTH_SHORT).show()


            }else{
                Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

            }
        }


    })
}

}
