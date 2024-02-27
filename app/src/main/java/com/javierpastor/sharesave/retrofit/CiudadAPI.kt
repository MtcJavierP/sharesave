package com.javierpastor.sharesave.retrofit

import retrofit2.http.GET

interface CiudadAPI {
    @GET("arbol.json")
    suspend fun getCiudades(): List<Ciudad>
}