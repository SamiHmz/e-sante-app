package com.example.e_sante

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl("http://3a8ce159acca.ngrok.io").
        addConverterFactory(GsonConverterFactory.create()).
        build().create(Endpoint::class.java)
    }
}