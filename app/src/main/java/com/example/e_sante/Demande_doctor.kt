package com.example.e_sante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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






        DemandeDoctor_button_traité.setOnClickListener { view ->
                requireActivity().findNavController(R.id.nav_fragment_doctor)
                    .navigate(R.id.action_demande_doctor_to_traitement_doctor)
            }
//botton retour
        DemandeDoctor_imageButton_retour.setOnClickListener{
            getActivity()?.onBackPressed()
        }
    }


}
