package com.example.e_sante

import java.time.LocalDateTime

data class Demande (
    val nom:String?,
    val prenom:String?,


    val id:Int,
    val symptomes:String,
    val autre_symptomes:String,
    val traitement:String,
    val image:String,
    var is_treated:Boolean,
    val createdAt:String,


    val updatedAt:String?,
    val medecin_id:Int?,
    val user_id:Int?
)