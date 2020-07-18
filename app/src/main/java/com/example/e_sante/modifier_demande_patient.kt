package com.example.e_sante

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.e_sante.entities.Demande_a_misajour
import kotlinx.android.synthetic.main.fragment_modifier_demande_patient.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class modifier_demande_patient : Fragment() {


    var listint= mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    var list_symptome : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modifier_demande_patient, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


////////// recuperation des données issues du detail demande patient //////////////////

        val id_demande = arguments?.getInt("id_demande")


//////////// button de mis a jour du demande ////////////////////////////////////////////////
        ModifierDemandePatient_Button_Envoyer.setOnClickListener{

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





            if (id_demande != null) {
                ModifierDemande(id_demande)
            }
        }
//////////////// botton des symptomes ////////////////////
       /* for(item in listjdid )
        {*/
        ModifierDemandePatient_Button_Fatigue.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[0] )== 0  ){

                ModifierDemandePatient_Button_Fatigue.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Fatigue.setTextColor(getResources().getColor(R.color.blanc))
                listint[0]=1
                }else{
                ModifierDemandePatient_Button_Fatigue.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Fatigue.setTextColor(getResources().getColor(R.color.gris))
                listint[0]=0
                }
            }

        ModifierDemandePatient_Button_Fievre.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[1] )== 0  ){

                ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Fievre.setTextColor(getResources().getColor(R.color.blanc))
                listint[1]=1
            }else{
                ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Fievre.setTextColor(getResources().getColor(R.color.gris))
                listint[1]=0
            }
        }

        ModifierDemandePatient_Button_MalAuGorge.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[2] )== 0  ){

                ModifierDemandePatient_Button_MalAuGorge.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_MalAuGorge.setTextColor(getResources().getColor(R.color.blanc))
                listint[2]=1
            }else{
                ModifierDemandePatient_Button_MalAuGorge.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_MalAuGorge.setTextColor(getResources().getColor(R.color.gris))
                listint[2]=0
            }
        }



        ModifierDemandePatient_Button_Grippe.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[3] )== 0  ){

                ModifierDemandePatient_Button_Grippe.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Grippe.setTextColor(getResources().getColor(R.color.blanc))
                listint[3]=1
            }else{
                ModifierDemandePatient_Button_Grippe.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Grippe.setTextColor(getResources().getColor(R.color.gris))
                listint[3]=0
            }
        }


        ModifierDemandePatient_Button_Alergie.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[4] )== 0  ){

                ModifierDemandePatient_Button_Alergie.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Alergie.setTextColor(getResources().getColor(R.color.blanc))
                listint[4]=1
            }else{
                ModifierDemandePatient_Button_Alergie.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Alergie.setTextColor(getResources().getColor(R.color.gris))
                listint[4]=0
            }
        }

        ModifierDemandePatient_Button_JambesLourdes.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[5] )== 0  ){

                ModifierDemandePatient_Button_JambesLourdes.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_JambesLourdes.setTextColor(getResources().getColor(R.color.blanc))
                listint[5]=1
            }else{
                ModifierDemandePatient_Button_JambesLourdes.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_JambesLourdes.setTextColor(getResources().getColor(R.color.gris))
                listint[5]=0
            }}

            ModifierDemandePatient_Button_MalAuDos.setOnClickListener{
                //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

                if ((listint[6] )== 0  ){

                    ModifierDemandePatient_Button_MalAuDos.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                    ModifierDemandePatient_Button_MalAuDos.setTextColor(getResources().getColor(R.color.blanc))
                    listint[6]=1
                }else{
                    ModifierDemandePatient_Button_MalAuDos.setBackground(getResources().getDrawable(R.drawable.arrondi))
                    ModifierDemandePatient_Button_MalAuDos.setTextColor(getResources().getColor(R.color.gris))
                    listint[6]=0
                }}

        ModifierDemandePatient_Button_toux.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[7] )== 0  ){

                ModifierDemandePatient_Button_toux.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_toux.setTextColor(getResources().getColor(R.color.blanc))
                listint[7]=1
            }else{
                ModifierDemandePatient_Button_toux.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_toux.setTextColor(getResources().getColor(R.color.gris))
                listint[7]=0
            }}

        ModifierDemandePatient_Button_Gastro.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[8] )== 0  ){

                ModifierDemandePatient_Button_Gastro.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Gastro.setTextColor(getResources().getColor(R.color.blanc))
                listint[8]=1
            }else{
                ModifierDemandePatient_Button_Gastro.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Gastro.setTextColor(getResources().getColor(R.color.gris))
                listint[8]=0
            }}

        ModifierDemandePatient_Button_MalDuVentre.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[9] )== 0  ){

                ModifierDemandePatient_Button_MalDuVentre.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_MalDuVentre.setTextColor(getResources().getColor(R.color.blanc))
                listint[9]=1
            }else{
                ModifierDemandePatient_Button_MalDuVentre.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_MalDuVentre.setTextColor(getResources().getColor(R.color.gris))
                listint[9]=0
            }}


        ModifierDemandePatient_Button_Rhinite.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[10] )== 0  ){

                ModifierDemandePatient_Button_Rhinite.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Rhinite.setTextColor(getResources().getColor(R.color.blanc))
                listint[10]=1
            }else{
                ModifierDemandePatient_Button_Rhinite.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Rhinite.setTextColor(getResources().getColor(R.color.gris))
                listint[10]=0
            }}

        ModifierDemandePatient_Button_Rhume.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[11] )== 0  ){

                ModifierDemandePatient_Button_Rhume.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Rhume.setTextColor(getResources().getColor(R.color.blanc))
                listint[11]=1
            }else{
                ModifierDemandePatient_Button_Rhume.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Rhume.setTextColor(getResources().getColor(R.color.gris))
                listint[11]=0
            }}



        ModifierDemandePatient_Button_MaladiePsychosomatiques.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[12] )== 0  ){

                ModifierDemandePatient_Button_MaladiePsychosomatiques.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_MaladiePsychosomatiques.setTextColor(getResources().getColor(R.color.blanc))
                listint[12]=1
            }else{
                ModifierDemandePatient_Button_MaladiePsychosomatiques.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_MaladiePsychosomatiques.setTextColor(getResources().getColor(R.color.gris))
                listint[12]=0
            }}


        ModifierDemandePatient_Button_BrulureDestomac.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[13] )== 0  ){

                ModifierDemandePatient_Button_BrulureDestomac.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_BrulureDestomac.setTextColor(getResources().getColor(R.color.blanc))
                listint[13]=1
            }else{
                ModifierDemandePatient_Button_BrulureDestomac.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_BrulureDestomac.setTextColor(getResources().getColor(R.color.gris))
                listint[13]=0
            }}

        ModifierDemandePatient_Button_Diarrhée.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[14] )== 0  ){

                ModifierDemandePatient_Button_Diarrhée.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Diarrhée.setTextColor(getResources().getColor(R.color.blanc))
                listint[14]=1
            }else{
                ModifierDemandePatient_Button_Diarrhée.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Diarrhée.setTextColor(getResources().getColor(R.color.gris))
                listint[14]=0
            }}


        ModifierDemandePatient_Button_Constipation.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[15] )== 0  ){

                ModifierDemandePatient_Button_Constipation.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_Constipation.setTextColor(getResources().getColor(R.color.blanc))
                listint[15]=1
            }else{
                ModifierDemandePatient_Button_Constipation.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_Constipation.setTextColor(getResources().getColor(R.color.gris))
                listint[15]=0
            }}


        ModifierDemandePatient_Button_IrritationDuPeau.setOnClickListener{
            //ModifierDemandePatient_Button_Fievre.setBackground(getResources().getDrawable(R.drawable.arrondi))

            if ((listint[16] )== 0  ){

                ModifierDemandePatient_Button_IrritationDuPeau.setBackground(getResources().getDrawable(R.drawable.arrondi_bleu_ciel))
                ModifierDemandePatient_Button_IrritationDuPeau.setTextColor(getResources().getColor(R.color.blanc))
                listint[16]=1
            }else{
                ModifierDemandePatient_Button_IrritationDuPeau.setBackground(getResources().getDrawable(R.drawable.arrondi))
                ModifierDemandePatient_Button_IrritationDuPeau.setTextColor(getResources().getColor(R.color.gris))
                listint[16]=0
            }}


/////////////// le botton arriere //////////////
        ModifierDemandePatient_imagebutton_retour.setOnClickListener{
                getActivity()?.onBackPressed()
            }
    }


private fun ModifierDemande(id_demande : Int)
{
    var sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity?.applicationContext)
    var edit : SharedPreferences.Editor = sp.edit()
    var token : String? = sp.getString("x-auth-token","No x-auth-token")

    val consultation =Demande_a_misajour(list_symptome,ModifierDemandePatient_edittext_symptomes.text.toString(),ModifierDemandePatient_editText_traitement.text.toString())

    val call= token?.let { RetrofitService.endpoint.modifier_demande(consultation,id_demande, it) }
    if (call != null) {
        call.enqueue(object : Callback<Demande> {
            override fun onFailure(call: Call<Demande>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"erreur : verifier votre connexion puis reesayer", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Demande>, response: Response<Demande>) {
                if(response.isSuccessful){

                    Toast.makeText(activity?.applicationContext,"Demande Modifié avec succes", Toast.LENGTH_SHORT).show()

                    requireActivity().findNavController(R.id.nav_fragment_patient)
                        .navigate(R.id.action_modifier_demande_patient_to_demande_patient)

                }else{
                    Toast.makeText(activity?.applicationContext,"${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()

                }
            }


        })
    }

}


private fun modifier_etat_buton(){

}
}
