package com.example.e_sante.adapter

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_sante.Demande
import com.example.e_sante.R
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

class DemandePatient_adapter (val context: Context, var data:List<Demande>): RecyclerView.Adapter<MyDemandePatientViewHolder>() {

    var sp: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
    var edit: SharedPreferences.Editor = sp.edit()


    var token: String? = sp.getString("x-auth-token", "No x-auth-token")
    var lien : String? = sp.getString("lien","No lien")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDemandePatientViewHolder {
        return MyDemandePatientViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_home_doctor,
                parent,
                false
            )
        )    }

    override fun getItemCount()= data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyDemandePatientViewHolder, position: Int)


    {




        holder.date.text = data[position].createdAt

        holder.name.text = data[position].nom +" "+data[position].prenom
//*/*/*/*/*/*/*/*//////////////  require implementation of other  //////////////////////////////////////////


        if (data[position].image != null) {
            Glide.with(context).load("$lien" +"/"+ "${data[position].image}").into(holder.image)
        }else {
            holder.image.setImageResource(R.drawable.groupe_3)
        }
///////////// aller vers le fragment de detail demande patient
        holder.itemView.setOnClickListener{view ->
            val bundle = bundleOf("id_demande" to data[position].id,
                            "symptomes" to data[position].symptomes,
                                "autre_symptomes" to  data[position].autre_symptomes,
                                "traitement" to data[position].traitement,
                                 "image" to data[position].image   )
            view.findNavController().navigate(R.id.action_demande_patient_to_detail_demande_patient,bundle)
        }

    }
}
class MyDemandePatientViewHolder(view: View): RecyclerView.ViewHolder(view){
    val name = view.findViewById(R.id.LayoutHomeDoctor_textview_nom) as TextView
    val date = view.findViewById(R.id.LayoutHomeDoctor_textview_date) as TextView
    val image = view.findViewById(R.id.imageView9) as ImageView
}