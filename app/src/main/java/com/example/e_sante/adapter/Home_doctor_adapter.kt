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
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_sante.Demande
import com.example.e_sante.R
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

class Home_doctor_adapter (val context: Context, var data:List<Demande>): RecyclerView.Adapter<MyHomeDoctorViewHolder>() {

    var sp: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
    var edit: SharedPreferences.Editor = sp.edit()


    var token: String? = sp.getString("x-auth-token", "No x-auth-token")
    var lien : String? = sp.getString("lien","No lien")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeDoctorViewHolder {
        return MyHomeDoctorViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_home_doctor,
                parent,
                false
            )
        )    }

    override fun getItemCount()= data.size


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyHomeDoctorViewHolder, position: Int) {
/*
        var dateInString: String? = data[position].createdAt
        var instant : Instant = Instant.parse(dateInString)

//get date time only
        var result : LocalDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

//get localdate*/

        holder.date.text = data[position].createdAt

        holder.name.text = data[position].nom +" "+data[position].prenom



        if (data[position].image != null) {
            Glide.with(context).load("$lien" +"/"+ "${data[position].image}").into(holder.photo)
        }else{

            holder.photo.setImageResource(R.drawable.groupe_3)

        }
/*///////////////a faire//////////////////////
        holder.temps
        holder.date*/
//////click sur le item/////////
        holder.itemView.setOnClickListener{view ->
///////passer des données au fragment demande doctor
            val Bundle = bundleOf("demande_id" to data[position].id,
                "symptome" to data[position].symptomes,
                "autre_symptome" to data[position].autre_symptomes,
                "traitement" to data[position].traitement,
            "image" to data[position].image)

            view.findNavController().navigate(R.id.action_home_doctor_to_demande_doctor,Bundle)
        }

    }
}

class MyHomeDoctorViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val name = view.findViewById(R.id.LayoutHomeDoctor_textview_nom) as TextView
    val date = view.findViewById(R.id.LayoutHomeDoctor_textview_date) as TextView
    val photo = view.findViewById(R.id.imageView9) as ImageView

}