package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_choix_medecin_patient.*

class Choix_medecin_patient : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choix_medecin_patient, container, false)


    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()


        Choix_button_Docteur.setOnClickListener{
            edit.putString("type","docteur")
            edit.apply()

            requireActivity().findNavController(R.id.nav_fragment)
                .navigate(R.id.action_choix_medecin_patient_to_login)
        }

        Choix_button_Patient.setOnClickListener{
            edit.putString("type","patient")
            edit.apply()

            requireActivity().findNavController(R.id.nav_fragment)
                .navigate(R.id.action_choix_medecin_patient_to_login_signup)
        }

    }
}
