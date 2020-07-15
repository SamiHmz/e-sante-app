package com.example.e_sante

import com.example.e_sante.entities.User_retour
import com.example.e_sante.entities.login_entity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Endpoint {
////////////////    get     ////////////////////////////////////////////////////////////////////////////////////
    @GET("api/v1/wilaya")
    fun getAllWilaya() :Call<List<Wilaya>>

    @GET("api/v1/comune/{id}")
    fun getAllCommune(@Path("id") id:Int) :Call<List<Commune>>

    @GET("api/v1/specialite")
    fun getAllSpecialite(@Header("x-auth-token") xauthtoken:String) :Call<List<Speciality>>

    @GET ("api/v1/demande")
    fun getAlldemande(@Header("x-auth-token") xauthtoken:String): Call<List<Demande>>

    @GET ("api/v1/consultation")
    fun getAllconsultation(@Header("x-auth-token") xauthtoken:String): Call<List<Consutation_BD>>




/////////////////    post     //////////////////////////////////////////////////////////////////////////////////
    @POST("api/v1/user/register/patient")
    fun ajouterUser(@Body user1:User):Call<User_retour>

    @POST("api/v1/user/login/medecin")
    fun login_doctor(@Body login:login_entity):Call<ResponseBody>

    @POST("api/v1/user/login/patient")
    fun login_patient(@Body login:login_entity):Call<String>
}