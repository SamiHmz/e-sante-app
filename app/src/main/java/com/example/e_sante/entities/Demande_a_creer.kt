package com.example.e_sante.entities

data class Demande_a_creer(
    val symptomes:String,
    val autre_symptomes:String,
    val traitement:String,
    val medecin_id:Int
)