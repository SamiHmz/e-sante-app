package com.example.e_sante

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Home_adapter (val context: Context, var data:List<Doctor>): RecyclerView.Adapter<MyHomeViewHolder>(){

    var sp: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
    var edit: SharedPreferences.Editor = sp.edit()


    var token: String? = sp.getString("x-auth-token", "No x-auth-token")
    var lien : String? = sp.getString("lien","No lien")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeViewHolder {
            return MyHomeViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.layout_home,
                    parent,
                    false
            ))   }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(holder: MyHomeViewHolder, position: Int) {
        holder.name.text ="Dr" +" "+data[position].nom +" "+ data[position].prenom
        holder.specialite.text = data[position].specialite
        holder.numero.text = data[position].numero

        if (data[position].photo != null) {
            Glide.with(context).load("$lien" +"/"+ "${data[position].photo}").into(holder.image)
        }else{
            holder.image.setImageResource(R.drawable.mask_group_2)

        }

//////click sur le item
        holder.itemView.setOnClickListener{view ->
///////a faire le passer des données au fragment du consultion

            val bundle = bundleOf("id_doctor" to data[position].id)
        view.findNavController().navigate(R.id.action_home2_to_demande_consultation,bundle)
        }
    }
}



 class MyHomeViewHolder(view: View): RecyclerView.ViewHolder(view){
    val name = view.findViewById(R.id.LayoutHome_textview_nom) as TextView
    val specialite = view.findViewById(R.id.LayoutHome_textview_Specialité) as TextView
    val numero =  view.findViewById(R.id.LayoutHome_textview_numero) as TextView
     val image = view.findViewById(R.id.imageView5) as ImageView
}