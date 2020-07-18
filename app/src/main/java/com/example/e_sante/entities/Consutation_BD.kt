package com.example.e_sante

import java.util.*


data class Consutation_BD (
    val id:Int,
    val diagnostic:String,
    val traitemnet:String,


    val date: String?,
    val nom:String?,
    val prenom:String?,


    val createdAt:String?,
    val updatedAt:String?,
    val demande_id:Int?,

    val image:String?



)