package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
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



        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()
        var lien : String? = sp.getString("lien","No lien")
////////// recuperation des données issues du demande patient //////////////////

        val id_demande = arguments?.getInt("id_demande")
        val symptomes = arguments?.getString("symptomes")
        val autre_symptomes = arguments?.getString("autre_symptomes")
        val traitement = arguments?.getString("traitement")
        val image = arguments?.getString("image")

//////////// chargement dans le layout //////////////////////////

        DetailDemandePatient_textview_symptomes.text=symptomes
        DetailDemandePatient_textview_AutreSymptomes.text=autre_symptomes
        DetailDemandePatient_textview_traitement.text=traitement

        if (image != null) {
            Glide.with(this).load("$lien" +"/"+ "$image").into(DetailDemandePatient_ImageView_photo)
        }



///////////     passage vers fragment modifier_demande_patient ////////////////////
        DetailDemandePatient_button_traité.setOnClickListener { view ->

            val bundle = bundleOf("id_demande" to id_demande)
        requireActivity().findNavController(R.id.nav_fragment_patient)
            .navigate(R.id.action_detail_demande_patient_to_modifier_demande_patient,bundle)}

//////////   le botton en retour ////////////////
        DetailDemandePatient_imageButton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }
}
