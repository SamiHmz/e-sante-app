package com.example.e_sante

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.e_sante.entities.Demande_a_creer
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_demande_consultation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class demande_consultation : Fragment() {

    var listint= mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    var list_symptome : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demande_consultation, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)










        demandeconsultation_Button_Fatigue.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[0] )== 0  ){

                demandeconsultation_Button_Fatigue.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Fatigue.setTextColor(getResources().getColor(R.color.blanc))
                listint[0]=1
            }else{
                demandeconsultation_Button_Fatigue.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Fatigue.setTextColor(getResources().getColor(R.color.gris))
                listint[0]=0
            }
        }

        demandeconsultation_Button_Fievre.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[1] )== 0  ){

                demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Fievre.setTextColor(getResources().getColor(R.color.blanc))
                listint[1]=1
            }else{
                demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Fievre.setTextColor(getResources().getColor(R.color.gris))
                listint[1]=0
            }
        }

        demandeconsultation_Button_MalAuGorge.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[2] )== 0  ){

                demandeconsultation_Button_MalAuGorge.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_MalAuGorge.setTextColor(getResources().getColor(R.color.blanc))
                listint[2]=1
            }else{
                demandeconsultation_Button_MalAuGorge.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_MalAuGorge.setTextColor(getResources().getColor(R.color.gris))
                listint[2]=0
            }
        }



        demandeconsultation_Button_Grippe.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[3] )== 0  ){

                demandeconsultation_Button_Grippe.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Grippe.setTextColor(getResources().getColor(R.color.blanc))
                listint[3]=1
            }else{
                demandeconsultation_Button_Grippe.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Grippe.setTextColor(getResources().getColor(R.color.gris))
                listint[3]=0
            }
        }


        demandeconsultation_Button_Alergie.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[4] )== 0  ){

                demandeconsultation_Button_Alergie.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Alergie.setTextColor(getResources().getColor(R.color.blanc))
                listint[4]=1
            }else{
                demandeconsultation_Button_Alergie.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Alergie.setTextColor(getResources().getColor(R.color.gris))
                listint[4]=0
            }
        }

        demandeconsultation_Button_JambesLourdes.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[5] )== 0  ){

                demandeconsultation_Button_JambesLourdes.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_JambesLourdes.setTextColor(getResources().getColor(R.color.blanc))
                listint[5]=1
            }else{
                demandeconsultation_Button_JambesLourdes.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_JambesLourdes.setTextColor(getResources().getColor(R.color.gris))
                listint[5]=0
            }}

        demandeconsultation_Button_MalAuDos.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[6] )== 0  ){

                demandeconsultation_Button_MalAuDos.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_MalAuDos.setTextColor(getResources().getColor(R.color.blanc))
                listint[6]=1
            }else{
                demandeconsultation_Button_MalAuDos.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_MalAuDos.setTextColor(getResources().getColor(R.color.gris))
                listint[6]=0
            }}

        demandeconsultation_Button_toux.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[7] )== 0  ){

                demandeconsultation_Button_toux.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_toux.setTextColor(getResources().getColor(R.color.blanc))
                listint[7]=1
            }else{
                demandeconsultation_Button_toux.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_toux.setTextColor(getResources().getColor(R.color.gris))
                listint[7]=0
            }}

        demandeconsultation_Button_Gastro.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[8] )== 0  ){

                demandeconsultation_Button_Gastro.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Gastro.setTextColor(getResources().getColor(R.color.blanc))
                listint[8]=1
            }else{
                demandeconsultation_Button_Gastro.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Gastro.setTextColor(getResources().getColor(R.color.gris))
                listint[8]=0
            }}

        demandeconsultation_Button_MalDuVentre.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[9] )== 0  ){

                demandeconsultation_Button_MalDuVentre.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_MalDuVentre.setTextColor(getResources().getColor(R.color.blanc))
                listint[9]=1
            }else{
                demandeconsultation_Button_MalDuVentre.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_MalDuVentre.setTextColor(getResources().getColor(R.color.gris))
                listint[9]=0
            }}


        demandeconsultation_Button_Rhinite.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[10] )== 0  ){

                demandeconsultation_Button_Rhinite.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Rhinite.setTextColor(getResources().getColor(R.color.blanc))
                listint[10]=1
            }else{
                demandeconsultation_Button_Rhinite.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Rhinite.setTextColor(getResources().getColor(R.color.gris))
                listint[10]=0
            }}

        demandeconsultation_Button_Rhume.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[11] )== 0  ){

                demandeconsultation_Button_Rhume.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Rhume.setTextColor(getResources().getColor(R.color.blanc))
                listint[11]=1
            }else{
                demandeconsultation_Button_Rhume.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Rhume.setTextColor(getResources().getColor(R.color.gris))
                listint[11]=0
            }}



        demandeconsultation_Button_MaladiePsychosomatiques.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[12] )== 0  ){

                demandeconsultation_Button_MaladiePsychosomatiques.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_MaladiePsychosomatiques.setTextColor(getResources().getColor(R.color.blanc))
                listint[12]=1
            }else{
                demandeconsultation_Button_MaladiePsychosomatiques.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_MaladiePsychosomatiques.setTextColor(getResources().getColor(R.color.gris))
                listint[12]=0
            }}


        demandeconsultation_Button_BrulureDestomac.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[13] )== 0  ){

                demandeconsultation_Button_BrulureDestomac.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_BrulureDestomac.setTextColor(getResources().getColor(R.color.blanc))
                listint[13]=1
            }else{
                demandeconsultation_Button_BrulureDestomac.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_BrulureDestomac.setTextColor(getResources().getColor(R.color.gris))
                listint[13]=0
            }}

        demandeconsultation_Button_Diarrhée.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[14] )== 0  ){

                demandeconsultation_Button_Diarrhée.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Diarrhée.setTextColor(getResources().getColor(R.color.blanc))
                listint[14]=1
            }else{
                demandeconsultation_Button_Diarrhée.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Diarrhée.setTextColor(getResources().getColor(R.color.gris))
                listint[14]=0
            }}


        demandeconsultation_Button_Constipation.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[15] )== 0  ){

                demandeconsultation_Button_Constipation.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_Constipation.setTextColor(getResources().getColor(R.color.blanc))
                listint[15]=1
            }else{
                demandeconsultation_Button_Constipation.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_Constipation.setTextColor(getResources().getColor(R.color.gris))
                listint[15]=0
            }}


        demandeconsultation_Button_IrritationDuPeau.setOnClickListener{
            //demandeconsultation_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[16] )== 0  ){

                demandeconsultation_Button_IrritationDuPeau.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                demandeconsultation_Button_IrritationDuPeau.setTextColor(getResources().getColor(R.color.blanc))
                listint[16]=1
            }else{
                demandeconsultation_Button_IrritationDuPeau.setBackground(getResources().getDrawable(R.drawable.arrondi))
                demandeconsultation_Button_IrritationDuPeau.setTextColor(getResources().getColor(R.color.gris))
                listint[16]=0
            }}








//////recuperation de lid depuis home patient ////////////////
        val id_doctor = arguments?.getInt("id_doctor")

        demandeconsultation_Button_Envoyer.setOnClickListener{
            if (id_doctor != null) {


                if((listint[0] )== 1){
                    list_symptome = "$list_symptome"+"Fatique"+" - "
                }
                if((listint[1] )== 1){
                    list_symptome = "$list_symptome"+"Fievre"+" - "
                }
                if((listint[2] )== 1){
                    list_symptome = "$list_symptome"+"Mal au gorge"+" - "
                }
                if((listint[3] )== 1){
                    list_symptome = "$list_symptome"+"Grippe"+" - "
                }
                if((listint[4] )== 1){
                    list_symptome = "$list_symptome"+"Alergie"+" - "
                }
                if((listint[5] )== 1){
                    list_symptome = "$list_symptome"+"Jambes Lourdes"+" - "
                }
                if((listint[6] )== 1){
                    list_symptome = "$list_symptome"+"Mal au dos"+" - "
                }
                if((listint[7] )== 1){
                    list_symptome = "$list_symptome"+"toux"+" - "
                }
                if((listint[8] )== 1){
                    list_symptome = "$list_symptome"+"Gastro"+" - "
                }
                if((listint[9] )== 1){
                    list_symptome = "$list_symptome"+"Mal de ventre"+" - "
                }
                if((listint[10] )== 1){
                    list_symptome = "$list_symptome"+"Rhinite"+" - "
                }
                if((listint[11] )== 1){
                    list_symptome = "$list_symptome"+"Rhume"+" - "
                }
                if((listint[12] )== 1){
                    list_symptome = "$list_symptome"+"Maladies psychosomatiques"+" - "
                }
                if((listint[13] )== 1){
                    list_symptome = "$list_symptome"+"Brulure"+" - "
                }
                if((listint[14] )== 1){
                    list_symptome = "$list_symptome"+"Diarrhé"+" - "
                }
                if((listint[15] )== 1){
                    list_symptome = "$list_symptome"+"Constipation"+" - "
                }
                if((listint[16] )== 1){
                    list_symptome = "$list_symptome"+"Irritation Du peau"+" - "
                }

                if((list_symptome)=="")
                {
                    list_symptome= "non specifié"
                }



                Ajouter_Demande(id_doctor)
            }
        }


//////////////////////boutton back
        demandeconsultation_imagebutton_retour.setOnClickListener{
            getActivity()?.onBackPressed()
        }

    }

private fun Ajouter_Demande(id_doctor:Int)
{
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val demande =Demande_a_creer(list_symptome,demandeconsultation_edittext_symptomes.text.toString(),
        demandeconsultation_editText_traitement.text.toString(),id_doctor)

    val call= token?.let { RetrofitService.endpoint.ajouter_demande(demande, it) }
    if (call != null) {
        call.enqueue(object : Callback<Demande> {
            override fun onFailure(call: Call<Demande>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<Demande>, response: Response<Demande>) {
                if(response.isSuccessful){
                    Toast.makeText(activity?.applicationContext,"Demande ajouté avec succes", Toast.LENGTH_SHORT).show()

                    requireActivity().findNavController(R.id.nav_fragment_patient)
                        .navigate(R.id.action_demande_consultation_to_home2)


                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }
}
}
