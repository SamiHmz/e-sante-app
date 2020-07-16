package com.example.e_sante

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl("http://9c3ad32ee0f5.ngrok.io").
        addConverterFactory(GsonConverterFactory.create()).
        build().create(Endpoint::class.java)
    }
}