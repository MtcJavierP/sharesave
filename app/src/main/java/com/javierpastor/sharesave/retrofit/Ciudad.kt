package com.javierpastor.sharesave.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//data class Ciudad(
//    val id: String,
//    val nombre: String,
//    val provincias: List<Provincia>
//)
//
//data class Provincia(
//    val id: String,
//    val nombre: String,
//    val poblaciones: List<Poblacion>
//)
//
//data class Poblacion(
//    val id: String,
//    val nombre: String
//)

@kotlinx.serialization.Serializable
data class Ciudad(
    @SerialName("code") val id: String,
    @SerialName("label") val nombre: String,
    @SerialName("provinces") val provincias: List<Provincia>
)

@kotlinx.serialization.Serializable
data class Provincia(
    @SerialName("code") val id: String,
    @SerialName("label") val nombre: String,
    @SerialName("towns") val poblaciones: List<Poblacion>
)

@Serializable
data class Poblacion(
    @SerialName("code") val id: String,
    @SerialName("label") val nombre: String
)