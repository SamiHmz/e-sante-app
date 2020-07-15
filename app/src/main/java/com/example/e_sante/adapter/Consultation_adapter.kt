package com.example.e_sante.entities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_sante.Consutation_BD
import com.example.e_sante.R


class Consultation_adapter (val context: Context, var data:List<Consutation_BD>): RecyclerView.Adapter<MyConsultationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyConsultationViewHolder {

        return MyConsultationViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_consultation,
                parent,
                false
            )
        )
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: MyConsultationViewHolder, position: Int) {
        holder.nom.text = "Dr"+" "+data[position].nom +" "+data[position].prenom
/////////// a faire //////////////////////
       // holder.date.text
        //holder.duree.text
//////////// a faire //////////////////////////////////////*/
        holder.point.setImageResource(R.drawable.ic_more_vert_48px)

//////click sur le item
        holder.itemView.setOnClickListener{view ->
///////a faire le passer des données au fragment du consultion
            //val bundle = bundleOf("doctor" to data[position].id)
            view.findNavController().navigate(R.id.action_consultation_to_details_de_consultation)
        }

    }

}

class MyConsultationViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    val nom = view.findViewById(R.id.LayoutConsultation_textView_nom) as TextView
    val date = view.findViewById(R.id.LayoutConsultation_textView_date) as TextView
    val duree = view.findViewById(R.id.LayoutConsultation_textView_duree) as TextView
    val photo = view.findViewById(R.id.LayoutConsultation_ImageView_photo) as ImageView
    val point = view.findViewById(R.id.imageView25) as ImageView
}