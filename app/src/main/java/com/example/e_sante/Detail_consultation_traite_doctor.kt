package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_detail_consultation_traite_doctor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail_consultation_traite_doctor : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_detail_consultation_traite_doctor,
            container,
            false
        )
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

///////////////// recuperation deouis bundle issu de consultation fait doctor ////////////////////////////////////

        val demande_id = arguments?.getInt("demande_id")
        val traitement = arguments?.getString("traitement")
        val diagnostique = arguments?.getString("diagnostique")
        val consultatio_id = arguments?.getInt("consultatio_id")

/////////// Affichage des informations /////////////////////////////////////////

        DetailConsultation_traite_textview_diagnostique.text=diagnostique
        DetailConsultation_traite_textview_traitement.text=traitement



////////////     passage vers fragment modifier consultation_traite_doctor ////////////////////
        DetailConsultation_traite_Button_Modifier.setOnClickListener {
            if (demande_id != null) {
                if (consultatio_id != null) {
                    GetdemandeByid(demande_id,consultatio_id)
                }

            }
            }
///////// botton retour /////////////
        DetailConsultation_traite_imageButton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }

private fun GetdemandeByid(demande_id:Int, consultatio_id:Int){
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val call= token?.let { RetrofitService.endpoint.getdemandeById(demande_id, it) }
    if (call != null) {
        call.enqueue(object : Callback<Demande> {
            override fun onFailure(call: Call<Demande>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Demande>, response: Response<Demande>) {
                    if(response.isSuccessful)
                    {
                        val demande= response.body()!!

                        val bundle = bundleOf("id" to demande.id,
                            "symptome" to demande.symptomes,
                            "autre_symptomes" to demande.autre_symptomes,
                        "traitement" to demande.traitement,
                        "image" to demande.image,
                        "consultatio_id" to consultatio_id)

                        requireActivity().findNavController(R.id.nav_fragment_doctor)
                            .navigate(R.id.action_detail_consultation_traite_doctor_to_detail_demande_doctor2,bundle)
                    }else{
                        Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                    }
            }

        })
    }

}

}
