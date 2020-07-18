package com.example.e_sante

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    lateinit var context :Context



    val endpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl("http://afd51050ee2a.ngrok.io").
        addConverterFactory(GsonConverterFactory.create()).
        build().create(Endpoint::class.java)
    }
}