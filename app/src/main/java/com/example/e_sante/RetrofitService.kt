package com.example.e_sante

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    lateinit var context :Context

var lien = "http://ad92b504dd40.ngrok.io"

    val endpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl(lien).
        addConverterFactory(GsonConverterFactory.create()).
        build().create(Endpoint::class.java)
    }
}