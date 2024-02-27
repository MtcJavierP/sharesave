package com.javierpastor.sharesave.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val ciudadAPI: CiudadAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/frontid/ComunidadesProvinciasPoblaciones/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CiudadAPI::class.java)
    }
}