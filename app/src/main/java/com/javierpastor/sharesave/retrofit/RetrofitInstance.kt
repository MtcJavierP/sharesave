package com.javierpastor.sharesave.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

//object RetrofitInstance {
  //  val ciudadAPI: CiudadAPI by lazy {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://raw.githubusercontent.com/frontid/ComunidadesProvinciasPoblaciones/master/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        retrofit.create(CiudadAPI::class.java)



                object RetrofitInstance {
                    val ciudadAPI: CiudadAPI by lazy {
                        val json = Json { ignoreUnknownKeys = true }

                        val client = OkHttpClient.Builder().build()

                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://raw.githubusercontent.com/frontid/ComunidadesProvinciasPoblaciones/master/")
                            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
                            .client(client)
                            .build()

                        retrofit.create(CiudadAPI::class.java)
                    }
                }