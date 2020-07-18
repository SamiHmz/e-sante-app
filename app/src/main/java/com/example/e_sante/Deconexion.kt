package com.example.e_sante

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_deconexion.*

class Deconexion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deconexion, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Choix_button_Deconnexion.setOnClickListener{


            var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
            var edit : SharedPreferences.Editor = sp.edit()

             edit.putString("type","")
            edit.putString("x-auth-token","")
            edit.apply()

            val intent = Intent(getActivity(),MainActivity::class.java)
            startActivity(intent)
        }
    }
}
