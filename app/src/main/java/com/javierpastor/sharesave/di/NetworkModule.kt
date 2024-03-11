package com.javierpastor.sharesave.di


import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.javierpastor.sharesave.retrofit.CiudadAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideCiudadAPI(): CiudadAPI {
        val json = Json {
            ignoreUnknownKeys = true
        }

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/frontid/ComunidadesProvinciasPoblaciones/master/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()

        return retrofit.create(CiudadAPI::class.java)
    }
}