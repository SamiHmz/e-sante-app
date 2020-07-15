package com.example.e_sante

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.e_sante.entities.User_retour
import kotlinx.android.synthetic.main.fragment_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Sign_up : Fragment() {

    var list_wilaya = listOf<Wilaya>()
    var list_wilaya2 = mutableListOf<String>()
    var list_commune = listOf<Commune>()
    var list_commune2 = mutableListOf<String>()
    var id_commune :Int = 0


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val t=inflater.inflate(R.layout.fragment_sign_up, container, false)

        getAllWilaya()
       /* */
        return t
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
 /////////////// click inscrire ////////////////////////
        Signup_button_Sinscrire.setOnClickListener{
            val useraCreer = User(Signup_editText_Nom.text.toString(),Signup_editText_prenom.text.toString(),
                Signup_editText_Email.text.toString(),Signup_editText_Numero.text.toString(),id_commune)
            addUser(useraCreer)
        }
    }

    private fun getAllWilaya() {
        val call = RetrofitService.endpoint.getAllWilaya()
        call.enqueue(object :Callback<List<Wilaya>>{
            override fun onFailure(call: Call<List<Wilaya>>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur :veuillez verifier la connexion et ressayer ", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<List<Wilaya>>, response: Response<List<Wilaya>>) {
                if (response.isSuccessful){


                    list_wilaya= response.body()!!
                    var i=0
                    for (item in list_wilaya)
                    {
                        list_wilaya2.add(item.nom)
                        i++
                    }
                    val spinner = view?.findViewById<Spinner>(R.id.Signup_spiner_Wilaya)
                    spinner?.adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.ghost_text, list_wilaya2.toList()) } as SpinnerAdapter
                    spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                        }

                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            getAllcommune(position+1)

                        }

                    }
                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }

        })

    }

    private fun getAllcommune(id_wilaya: Int) {
        val call = RetrofitService.endpoint.getAllCommune(id_wilaya)
        call.enqueue(object :Callback<List<Commune>>{
            override fun onFailure(call: Call<List<Commune>>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur :veuillez verifier la connexion et ressayer ", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Commune>>, response: Response<List<Commune>>) {
                if(response.isSuccessful){

                    list_commune= response.body()!!
                     list_commune2 = mutableListOf<String>()

                    for (item in list_commune)
                    {
                        list_commune2.add(item.nom)
                    }

                    val spinner_commune = view?.findViewById<Spinner>(R.id.Signup_spinner_commune)
                    spinner_commune?.adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.ghost_text, list_commune2) } as SpinnerAdapter
                    spinner_commune?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                        }

                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            id_commune= list_commune[position].id

                        }

                    }




                }
                else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }

        })
    }
private fun addUser(user1:User){
    val call = RetrofitService.endpoint.ajouterUser(user1)
    call.enqueue(object :Callback<User_retour>{
        override fun onFailure(call: Call<User_retour>, t: Throwable) {
            Toast.makeText(activity?.applicationContext,"erreur : verifier la connexion puis reesayer", Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<User_retour>, response: Response<User_retour>) {
            if (response.isSuccessful){
                Toast.makeText(activity?.applicationContext,"Utilisateur ajouter avec succes", Toast.LENGTH_SHORT).show()


            }
            else
            {

                Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

            }
        }

    })
}



}
