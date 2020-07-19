package com.example.e_sante

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first__page)


        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var edit : SharedPreferences.Editor = sp.edit()
        val lien ="http://5e8f29447717.ngrok.io"
        edit.putString("lien",lien)
        edit.apply()

        val background = object : Thread() {
            override fun run() {
                try {
                    var sp: SharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(this@SplashScreenActivity)
                    var edit: SharedPreferences.Editor = sp.edit()


                    var token: String? = sp.getString("x-auth-token", "No x-auth-token")
                    var type : String? = sp.getString("type","No type")

                    Thread.sleep(3000)

                  if((token !="No x-auth-token")and(token != "")){
                    if(type =="docteur" ){
                        val intent =Intent(baseContext, activity_doctor::class.java)
                        startActivity(intent)
                    }
                    else{
                        if (type =="patient"){
                            val intent =Intent(baseContext, Activity_patient::class.java)
                            startActivity(intent)
                        }else{
                            val intent =Intent(baseContext, MainActivity::class.java)
                            startActivity(intent)
                        }

                    }}else{
                      val intent =Intent(baseContext, MainActivity::class.java)
                      startActivity(intent)
                  }





                } catch (e :Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
