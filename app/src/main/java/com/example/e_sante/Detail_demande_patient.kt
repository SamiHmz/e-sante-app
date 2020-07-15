package com.example.e_sante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_detail_demande_patient.*

class Detail_demande_patient : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_demande_patient, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


///////////     passage vers fragment modifier_demande_patient ////////////////////
        DetailDemandePatient_button_traité.setOnClickListener { view ->
        requireActivity().findNavController(R.id.nav_fragment_patient)
            .navigate(R.id.action_detail_demande_patient_to_modifier_demande_patient)}

//////////   le botton en retour ////////////////
        DetailDemandePatient_imageButton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }
}
