package com.example.e_sante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDateTime

class Activity_patient : AppCompatActivity() {

//les fragments
    lateinit var home_fragment: Home
    lateinit var consultation_fragment: Consultation

 //lancement de lactivité
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)


//les buttons du bottom nav bar
        val bottonnavigation : BottomNavigationView = findViewById(R.id.btn_navbar)
        val navcontroller = findNavController(R.id.nav_fragment_patient)
         bottonnavigation.setupWithNavController(navcontroller)





    }
}
