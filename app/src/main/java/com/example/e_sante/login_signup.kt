package com.example.e_sante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login_signup.*

class login_signup : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_signup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//transaction vers login
        LoginSignUp_button_SeConnecter.setOnClickListener { view ->
            activity!!.findNavController(R.id.nav_fragment)
                .navigate(R.id.action_login_signup_to_login)
        }
//transaction vers signup
        LoginSignUp_button_Sinscrire.setOnClickListener {
            activity!!.findNavController(R.id.nav_fragment)
                .navigate(R.id.action_login_signup_to_sign_up)
        }

    }
}