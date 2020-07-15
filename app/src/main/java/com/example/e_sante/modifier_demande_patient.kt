package com.example.e_sante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_modifier_demande_patient.*

class modifier_demande_patient : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modifier_demande_patient, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

/////////////// le botton arriere //////////////
        ModifierDemandePatient_imagebutton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }
}
