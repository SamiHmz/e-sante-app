package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {
    var list_All_Specialite = listOf<Speciality>()
    var list_All_Specialite2 = mutableListOf<String>()

    private val list_doctor = mutableListOf(
        Doctor(2,"dahamni","youcef","cardiologue","0656751443","2"),
                Doctor(2,"dahamni","youcef","cardiologue","0656751443","2")
    )

    val list_specialite= mutableListOf("churigien","dentist")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()

///////spinner specialitz
        val t=inflater.inflate(R.layout.fragment_home, container, false)
        Afficher_Specialité()

        return t

    }





    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        home_recyclerview.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = Home_adapter(context ,list_doctor)
        }


/////////////// filter pour afficher spinner des specialites
        home_ImageView_fillter.setOnClickListener{
            cardView5.setVisibility(View.VISIBLE)
            home_spinner_filtre.setVisibility(View.VISIBLE)
        }
        }



private fun Afficher_Specialité(){
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")
    val call = token?.let { RetrofitService.endpoint.getAllSpecialite(it) }

    if (call != null) {
        call.enqueue(object : Callback<List<Speciality>> {

            override fun onFailure(call: Call<List<Speciality>>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<List<Speciality>>, response: Response<List<Speciality>>) {
                if(response.isSuccessful){
                    list_All_Specialite= response.body()!!
                    list_All_Specialite2 = mutableListOf<String>()

                    for (item in list_All_Specialite)
                    {
                        list_All_Specialite2.add(item.nom)
                    }
                    val spinner = view?.findViewById<Spinner>(R.id.home_spinner_filtre)
                    spinner?.adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.ghost_text, list_All_Specialite2) } as SpinnerAdapter
                    spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }

                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        }

                    }

                }else{

                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }

        })
    }

    }

}


