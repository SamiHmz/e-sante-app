package com.example.e_sante.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_sante.Demande
import com.example.e_sante.R

class DemandePatient_adapter (val context: Context, var data:List<Demande>): RecyclerView.Adapter<MyDemandePatientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDemandePatientViewHolder {
        return MyDemandePatientViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_home_doctor,
                parent,
                false
            )
        )    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: MyDemandePatientViewHolder, position: Int) {
        holder.name.text = data[position].nom +" "+data[position].prenom
//*/*/*/*/*/*/*/*//////////////  require implementation of other  //////////////////////////////////////////



///////////// aller vers le fragment de detail demande patient
        holder.itemView.setOnClickListener{view ->
            val bundle = bundleOf("id_demande" to data[position].id,
                            "symptomes" to data[position].symptomes,
                                "autre_symptomes" to  data[position].autre_symptomes,
                                "traitement" to data[position].traitement)
            view.findNavController().navigate(R.id.action_demande_patient_to_detail_demande_patient,bundle)
        }

    }
}
class MyDemandePatientViewHolder(view: View): RecyclerView.ViewHolder(view){
    val name = view.findViewById(R.id.LayoutHomeDoctor_textview_nom) as TextView
    val temps = view.findViewById(R.id.LayoutHomeDoctor_textview_temps) as TextView
    val date = view.findViewById(R.id.LayoutHomeDoctor_textview_date) as TextView
}