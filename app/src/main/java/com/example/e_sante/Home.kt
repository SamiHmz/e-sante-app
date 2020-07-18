package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.text.TextWatcher
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
    var list_doctor = listOf<Doctor>()
    var list_specialite_pour_watcher = listOf<Doctor>()






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
        var edit : SharedPreferences.Editor = sp.edit()

///////spinner specialitz
        val t=inflater.inflate(R.layout.fragment_home, container, false)
        //spin_kit8.visibility=View.VISIBLE
        AfficehrMedecin()
        Afficher_Specialité()

        return t

    }





    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



/////////////// filter pour afficher spinner des specialites
        home_ImageView_fillter.setOnClickListener{

            if(home_spinner_filtre.visibility == (View.VISIBLE)){
                cardView5.setVisibility(View.GONE)
                home_spinner_filtre.setVisibility(View.GONE)

                home_recyclerview.adapter= activity?.applicationContext?.let {
                    Home_adapter(
                        it,list_doctor) }
                home_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)
            }
                else{
            cardView5.setVisibility(View.VISIBLE)
            home_spinner_filtre.setVisibility(View.VISIBLE)}
        }


        home_edittext_recherche.addTextChangedListener(object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                var i =0}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                var i =0            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                 var new_list_pour_watcher= mutableListOf<Doctor>()


                 for (item in list_specialite_pour_watcher)
                 {
                    var c = "$item.nom"+" "+"$item.prenom"
                        c=c.trim().toUpperCase()
                     var d= s.toString().trim().toUpperCase()


                        if(c.contains(d))
                     {
                         new_list_pour_watcher.add(item)
                     }
                 }

                 home_recyclerview.adapter= activity?.applicationContext?.let {
                     Home_adapter(
                         it,new_list_pour_watcher) }
                 home_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)

             }
        })

    }



private fun Afficher_Specialité(){
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")
    var lien : String? = sp.getString("lien","No lien")

    val call = token?.let { RetrofitService.endpoint.getAllSpecialite(it) }

    if (call != null) {
        call.enqueue(object : Callback<List<Speciality>> {

            override fun onFailure(call: Call<List<Speciality>>, t: Throwable) {
                spin_kit8.visibility=View.INVISIBLE

                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<List<Speciality>>, response: Response<List<Speciality>>) {
                spin_kit8.visibility=View.INVISIBLE

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
                            if(home_spinner_filtre.visibility == (View.VISIBLE))
                            {list_specialite_pour_watcher=triParSpecialite(list_All_Specialite2[position],list_doctor)

                                home_recyclerview.adapter= activity?.applicationContext?.let {
                                    Home_adapter(
                                        it,list_specialite_pour_watcher) }
                                home_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)

                            }

                        }

                    }

                }else{

                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }

        })
    }

    }


private fun AfficehrMedecin() {

    var sp: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit: SharedPreferences.Editor = sp.edit()
    var token: String? = sp.getString("x-auth-token", "No x-auth-token")
    var lien : String? = sp.getString("lien","No lien")



    val call = token?.let { RetrofitService.endpoint.gestAllDoctors(it) }
    if (call != null) {
        call.enqueue(object : Callback<List<Doctor>> {
            override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Doctor>>, response: Response<List<Doctor>>) {
                    if (response.isSuccessful){

                         list_doctor= response.body()!!
                        list_specialite_pour_watcher= list_doctor


                        home_recyclerview.adapter= activity?.applicationContext?.let {
                            Home_adapter(
                                it,list_doctor) }
                        home_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)

                       /* home_recyclerview.apply{
                            layoutManager = LinearLayoutManager(activity)
                            adapter = Home_adapter(context ,list_doctor)
                        }*/


                    }else{
                        Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                    }
            }

        })

        }
    }

private fun triParSpecialite(specialite :String, list:List<Doctor>):List<Doctor>
{
    val new_list = mutableListOf<Doctor>()
    for (item in list)
    {
        if(item.specialite.equals(specialite))
        {
            new_list.add(item)
        }

    }
    return new_list
}


/*
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

           /* var new_list_pour_watcher= mutableListOf<Doctor>()


            for (item in list_specialite_pour_watcher)
            {
                if(s?.let { item.nom.contains(it) }?.or(s?.let { item.prenom.contains(it) }!!)!!){
                    new_list_pour_watcher.add(item)
                }
            }

            home_recyclerview.adapter= activity?.applicationContext?.let {
                Home_adapter(
                    it,new_list_pour_watcher) }
            home_recyclerview.layoutManager=LinearLayoutManager(activity?.applicationContext)

            */}
        }
*/
}


