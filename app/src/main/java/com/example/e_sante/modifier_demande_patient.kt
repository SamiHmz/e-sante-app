package com.example.e_sante

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_sante.entities.Demande_a_misajour
import kotlinx.android.synthetic.main.fragment_modifier_demande_patient.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class modifier_demande_patient : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modifier_demande_patient, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


////////// recuperation des données issues du detail demande patient //////////////////

        val id_demande = arguments?.getInt("id_demande")


//////////// button de mis a jour du demande ////////////////////////////////////////////////
        ModifierDemandePatient_Button_Envoyer.setOnClickListener{
            if (id_demande != null) {
                ModifierDemande(id_demande)
            }
        }
//////////////// botton des symptomes ////////////////////
        ModifierDemandePatient_Button_Fatigue.setOnClickListener{
            ModifierDemandePatient_Button_Fatigue.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))

        }

/////////////// le botton arriere //////////////
        ModifierDemandePatient_imagebutton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }


private fun ModifierDemande(id_demande : Int)
{
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val consultation =Demande_a_misajour("1234545",ModifierDemandePatient_edittext_symptomes.text.toString(),ModifierDemandePatient_editText_traitement.text.toString())
    val call= token?.let { RetrofitService.endpoint.modifier_demande(consultation,id_demande, it) }
    if (call != null) {
        call.enqueue(object : Callback<Demande> {
            override fun onFailure(call: Call<Demande>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Demande>, response: Response<Demande>) {
                if(response.isSuccessful){

                    Toast.makeText(activity?.applicationContext,"Demande Modifié avec succes", Toast.LENGTH_SHORT).show()


                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }


        })
    }

}


private fun modifier_etat_buton(){

}
}
