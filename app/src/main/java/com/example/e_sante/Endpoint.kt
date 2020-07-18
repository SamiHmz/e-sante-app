package com.example.e_sante

import com.example.e_sante.entities.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Multipart

interface Endpoint {
////////////////    get     ////////////////////////////////////////////////////////////////////////////////////
    @GET("api/v1/wilaya")
    fun getAllWilaya() :Call<List<Wilaya>>

    @GET("api/v1/comune/{id}")
    fun getAllCommune(@Path("id") id:Int) :Call<List<Commune>>

    @GET("api/v1/specialite")
    fun getAllSpecialite(@Header("x-auth-token") xauthtoken:String) :Call<List<Speciality>>

    //@Multipart
    @GET ("api/v1/demande")
    fun getAlldemande(@Header("x-auth-token") xauthtoken:String): Call<List<Demande>>
//, @Part image: MultipartBody


    @GET ("api/v1/consultation")
    fun getAllconsultation(@Header("x-auth-token") xauthtoken:String): Call<List<Consutation_BD>>

    @GET("api/v1/user/doctors")
    fun gestAllDoctors(@Header("x-auth-token") xauthtoken:String) :Call<List<Doctor>>

    @GET("api/v1/demande/{id}")
    fun getdemandeById(@Path("id") id:Int,@Header("x-auth-token") xauthtoken:String) :Call<Demande>

    @GET("api/v1/dashboard")
    fun getIndicateurDashbord(@Header("x-auth-token") xauthtoken:String):Call<Dashbord_BD>



/////////////////    post     //////////////////////////////////////////////////////////////////////////////////
    @POST("api/v1/user/register/patient")
    fun ajouterUser(@Body user1:User):Call<User_retour>

    @POST("api/v1/user/login/medecin")
    fun login_doctor(@Body login:login_entity):Call<ResponseBody>

    @POST("api/v1/user/login/patient")
    fun login_patient(@Body login:login_entity):Call<ResponseBody>

    @POST("api/v1/consultation")
    fun ajouter_consultation(@Body consultation:Consultation_a_creer, @Header("x-auth-token") xauthtoken:String):Call<Consutation_BD>

    @POST("api/v1/demande")
    fun ajouter_demande(@Body demande:Demande_a_creer, @Header("x-auth-token") xauthtoken:String):Call<Demande>

/////////////////     put     ////////////////////////////////////////////////////////////////////////////////

    @PUT("api/v1/demande/{id}")
    fun modifier_demande(@Body demande:Demande_a_misajour,@Path("id") id:Int,@Header("x-auth-token") xauthtoken:String): Call<Demande>

    @PUT("api/v1/consultation/{id}")
    fun modifier_consultation(@Body consultation:Consultation_a_misajour,@Path("id") id:Int,@Header("x-auth-token") xauthtoken:String): Call<Consutation_BD>

///////////////////// image trasformation ////////////////////////////////////////////////////////////////



}