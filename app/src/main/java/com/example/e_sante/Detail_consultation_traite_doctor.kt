package com.example.e_sante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_detail_consultation_traite_doctor.*

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

        val id_consultationn = arguments?.getInt("consultation_id")
        val traitement = arguments?.getString("traitement")
        val diagnostique = arguments?.getString("diagnostique")

/////////// Affichage des informations /////////////////////////////////////////

        DetailConsultation_traite_textview_diagnostique.text=diagnostique
        DetailConsultation_traite_textview_traitement.text=traitement



////////////     passage vers fragment modifier consultation_traite_doctor ////////////////////
        DetailConsultation_traite_Button_Modifier.setOnClickListener { view ->
                requireActivity().findNavController(R.id.nav_fragment_doctor)
                    .navigate(R.id.action_detail_consultation_traite_doctor_to_modifier_consultation_fait_doctor)
            }
///////// botton retour /////////////
        DetailConsultation_traite_imageButton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }
}
