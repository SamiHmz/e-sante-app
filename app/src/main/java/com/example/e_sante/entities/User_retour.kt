package com.example.e_sante.entities

data class User_retour (
    val id:Int,
    val nom:String,
    val prenom:String,
    val numero:String,
    val email:String,
    val comune_id:Int,
    val pass:String,
    val pass_text:String
)