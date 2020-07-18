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
import kotlinx.android.synthetic.main.fragment_detail_demande_doctor.*


class Detail_demande_doctor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_demande_doctor, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()
        var lien : String? = sp.getString("lien","No lien")


        val id_demande = arguments?.getInt("id")
        val symptomes = arguments?.getString("symptome")
        val autre_symptomes = arguments?.getString("autre_symptomes")
        val traitement = arguments?.getString("traitement")
        val image =  arguments?.getString("image")

        DetailDemandeDoctor_textview_symptomes.text=symptomes
        DetailDemandeDoctor_textview_AutreSymptomes.text=autre_symptomes
        DetailDemandeDoctor_textview_traitement.text=traitement

        if (image != null) {

            Glide.with(this).load("$lien" +"/"+ "$image").into(DetailDemandeDoctor_ImageView_photo)
        }

        DetailDemandeDoctor_button_traité.setOnClickListener{
            val bundle = bundleOf("id" to id_demande)

            requireActivity().findNavController(R.id.nav_fragment_doctor)
                .navigate(R.id.action_detail_demande_doctor2_to_modifier_consultation_fait_doctor,bundle)

        }


////////////////botton retour
        DetailDemandeDoctor_imageButton_retour.setOnClickListener {
                getActivity()?.onBackPressed()
            }
    }
}