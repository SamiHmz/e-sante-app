package com.example.e_sante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_demande_doctor.*


class Demande_doctor : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demande_doctor, container, false)
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

////////// recuperation des données issues du demande patient //////////////////

        val id_demande = arguments?.getInt("demande_id")
        val symptomes = arguments?.getString("symptome")
        val autre_symptomes = arguments?.getString("autre_symptome")
        val traitement = arguments?.getString("traitement")

        DemandeDoctor_textview_symptomes.text=symptomes
        DemandeDoctor_textview_AutreSymptomes.text=autre_symptomes
        DemandeDoctor_textview_traitement.text=traitement


/////////// bouton pour traiter ///////////
        DemandeDoctor_button_traité.setOnClickListener { view ->
            val Bundle = bundleOf("demande_id" to id_demande)
            requireActivity().findNavController(R.id.nav_fragment_doctor)
                    .navigate(R.id.action_demande_doctor_to_traitement_doctor,Bundle)
            }
////////////////botton retour
        DemandeDoctor_imageButton_retour.setOnClickListener{
            getActivity()?.onBackPressed()
        }
    }


}
