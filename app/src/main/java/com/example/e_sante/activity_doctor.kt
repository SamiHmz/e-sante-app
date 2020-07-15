package com.example.e_sante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class activity_doctor : AppCompatActivity() {

    //les fragments
    lateinit var home_doctor_fragment: Home_doctor
    lateinit var dashbord_fragment: dashbord_doctor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)





//les buttons du bottom nav bar
        val bottonnavigation : BottomNavigationView = findViewById(R.id.bottom_navigationview_doctor)
        val navcontroller1 = findNavController(R.id.nav_fragment_doctor)
        bottonnavigation.setupWithNavController(navcontroller1)

    }
}
