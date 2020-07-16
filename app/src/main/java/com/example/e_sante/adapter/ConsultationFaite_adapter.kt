package com.example.e_sante.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_sante.Consultation
import com.example.e_sante.Consutation_BD
import com.example.e_sante.R

class ConsultationFaite_adapter (val context: Context, var data:List<Consutation_BD>): RecyclerView.Adapter<MyConsultationFaite_adapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyConsultationFaite_adapterViewHolder {
        return MyConsultationFaite_adapterViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_consultation,
                parent,
                false
            )
        )    }

    override fun getItemCount()= data.size


    override fun onBindViewHolder(holder: MyConsultationFaite_adapterViewHolder, position: Int) {
        holder.nom.text = "Dr"+" "+data[position].nom +" "+data[position].prenom
///*/*/*/*/*/*/*/*/*/*/*/implment other parameter *


        holder.itemView.setOnClickListener{view ->
///////a faire le passer des données au fragment du consultion
            val bundle = bundleOf("consultation_id" to data[position].id,
                                        "diagnostique" to data[position].diagnostic,
                                        "traitement" to data[position].traitemnet)


            view.findNavController().navigate(R.id.action_consultation_faite_doctor_to_detail_consultation_traite_doctor,bundle)
        }



    }
}


class MyConsultationFaite_adapterViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    val nom = view.findViewById(R.id.LayoutConsultation_textView_nom) as TextView
    val date = view.findViewById(R.id.LayoutConsultation_textView_date) as TextView
    val duree = view.findViewById(R.id.LayoutConsultation_textView_duree) as TextView
    val photo = view.findViewById(R.id.LayoutConsultation_ImageView_photo) as ImageView
}
