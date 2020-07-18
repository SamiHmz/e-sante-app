

package com.example.e_sante.entities

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
import com.example.e_sante.Consutation_BD
import com.example.e_sante.R
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset


class Consultation_adapter (val context: Context, var data:List<Consutation_BD>): RecyclerView.Adapter<MyConsultationViewHolder>(){



    var sp: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
    var edit: SharedPreferences.Editor = sp.edit()


    var token: String? = sp.getString("x-auth-token", "No x-auth-token")
    var lien : String? = sp.getString("lien","No lien")
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyConsultationViewHolder, position: Int) {

        var dateInString: String? = data[position].date
        var instant : Instant = Instant.parse(dateInString)

//get date time only
        var result : LocalDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

//get localdate

        holder.date.text = result.toLocalDate().toString()


        holder.nom.text = "Dr"+" "+data[position].nom +" "+data[position].prenom
/////////// a faire //////////////////////
        // holder.date.text
        //holder.duree.text
//////////// a faire //////////////////////////////////////*/
        holder.point.setImageResource(R.drawable.ic_more_vert_48px)


        if (data[position].image != null) {
            Glide.with(context).load("$lien" +"/"+ "${data[position].image}").into(holder.photo)
        }else{
            holder.photo.setImageResource(R.drawable.mask_group_2)
        }
//////click sur le item
        holder.itemView.setOnClickListener{view ->
///////a faire le passer des données au fragment du consultion
            val bundle = bundleOf("diagnostique" to data[position].diagnostic, "traitement" to data[position].traitemnet )
            view.findNavController().navigate(R.id.action_consultation_to_details_de_consultation,bundle)
        }

    }

}

class MyConsultationViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    val nom = view.findViewById(R.id.LayoutConsultation_textView_nom) as TextView
    val date = view.findViewById(R.id.LayoutConsultation_textView_date) as TextView
    val photo = view.findViewById(R.id.LayoutConsultation_ImageView_photo) as ImageView
    val point = view.findViewById(R.id.imageView25) as ImageView
}







/*

var dateInString: String? = data[position].date
var instant : Instant = Instant.parse(dateInString)

//get date time only
var result : LocalDateTime  = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

//get localdate

holder.date.text = result.toLocalDate().toString()


 */