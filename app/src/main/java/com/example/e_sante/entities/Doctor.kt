package com.example.e_sante

data class Doctor (
    val id:Int,
    val nom:String,
    val prenom:String,
    val numero:String,
    val email:String,
    val photo:String,
    val specialite_id:Int,
    val specialite:String
)
