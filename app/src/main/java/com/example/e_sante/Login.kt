package com.example.e_sante

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_sante.entities.login_entity
import kotlinx.android.synthetic.main.fragment_login.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)


        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()
        var type : String? = sp.getString("type","No type")

        login_button_SeCommencer.setOnClickListener{

           var loginentity = login_entity(login_editText_numero.text.toString(),login_edittext_MotDePass.text.toString())
            if(type =="docteur" ){login_medcin(loginentity)}
                if (type =="patient"){login_patient((loginentity))}

        }
    }

private fun login_medcin(login:login_entity){

    val call = RetrofitService.endpoint.login_doctor(login)
    call.enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(activity?.applicationContext,"error : veuiilez verifier votre connexion puis reessayer", Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if(response.isSuccessful){

                var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
                var edit : SharedPreferences.Editor = sp.edit()
                edit.putString("x-auth-token",response.body()!!.string())
                edit.apply()
                val intent = Intent(getActivity(),activity_doctor::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

            }
        }

    })

}

private fun login_patient(login:login_entity){
    val call = RetrofitService.endpoint.login_patient(login)
    call.enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(activity?.applicationContext,"error : veuiilez verifier votre connexion puis reessayer 00", Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if(response.isSuccessful){


                var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
                var edit : SharedPreferences.Editor = sp.edit()
                edit.putString("x-auth-token",response.body()!!.string())
                edit.apply()
                val intent = Intent(getActivity(),Activity_patient::class.java)
                startActivity(intent)


            }else{
                Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

            }
        }


    })
}

}
