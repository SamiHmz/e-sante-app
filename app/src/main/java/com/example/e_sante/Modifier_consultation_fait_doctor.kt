package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.e_sante.entities.Consultation_a_creer
import com.example.e_sante.entities.Consultation_a_misajour
import kotlinx.android.synthetic.main.fragment_modifier_consultation_fait_doctor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Modifier_consultation_fait_doctor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_modifier_consultation_fait_doctor,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val id_demande = arguments?.getInt("id")
        val consultatio_id=  arguments?.getInt("consultatio_id")
///////////////   click sur Envoyer demande de refaire la consultation////////////////////////
        ModifierConsultationFaitDoctor_button_Envoyer.setOnClickListener{


            if (consultatio_id != null) {
                MidifierConsultation(consultatio_id)
            }

        }

/////////////// botton arriere /////////////
        ModifierConsultationFaitDoctor_imageButton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }


private fun MidifierConsultation(id_demande:Int){
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val consultation = Consultation_a_misajour(
        ModifierConsultationFaitDoctor_edit_text_Diagnostique.text.toString(),
        ModifierConsultationFaitDoctor_edittext_traitement.text.toString()
    )



    val call= token?.let {
        RetrofitService.endpoint.modifier_consultation(consultation,id_demande,
            it
        )
    }
    if (call != null) {
        call.enqueue(object : Callback<Consutation_BD> {
            override fun onFailure(call: Call<Consutation_BD>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<Consutation_BD>, response: Response<Consutation_BD>) {
                if(response.isSuccessful){
                    Toast.makeText(activity?.applicationContext,"Consultation Modifié avec succes", Toast.LENGTH_SHORT).show()

                    requireActivity().findNavController(R.id.nav_fragment_doctor)
                        .navigate(R.id.action_modifier_consultation_fait_doctor_to_consultation_faite_doctor)


                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }

}

}
