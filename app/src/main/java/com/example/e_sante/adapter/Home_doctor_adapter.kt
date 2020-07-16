package com.example.e_sante.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_sante.Demande
import com.example.e_sante.R

class Home_doctor_adapter (val context: Context, var data:List<Demande>): RecyclerView.Adapter<MyHomeDoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeDoctorViewHolder {
        return MyHomeDoctorViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_home_doctor,
                parent,
                false
            )
        )    }

    override fun getItemCount()= data.size


    override fun onBindViewHolder(holder: MyHomeDoctorViewHolder, position: Int) {
        holder.name.text = data[position].nom +" "+data[position].prenom
/*///////////////a faire//////////////////////
        holder.temps
        holder.date*/
//////click sur le item/////////
        holder.itemView.setOnClickListener{view ->
///////passer des données au fragment demande doctor
            val Bundle = bundleOf("demande_id" to data[position].id,
                "symptome" to data[position].symptomes,
                "autre_symptome" to data[position].autre_symptomes,
                "traitement" to data[position].traitement)

            view.findNavController().navigate(R.id.action_home_doctor_to_demande_doctor,Bundle)
        }

    }
}

class MyHomeDoctorViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val name = view.findViewById(R.id.LayoutHomeDoctor_textview_nom) as TextView
    val temps = view.findViewById(R.id.LayoutHomeDoctor_textview_temps) as TextView
    val date = view.findViewById(R.id.LayoutHomeDoctor_textview_date) as TextView

}