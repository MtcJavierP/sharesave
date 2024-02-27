package com.javierpastor.sharesave.retrofit

data class Ciudad(
    val id: String,
    val nombre: String,
    val provincias: List<Provincia>
)

data class Provincia(
    val id: String,
    val nombre: String,
    val poblaciones: List<Poblacion>
)

data class Poblacion(
    val id: String,
    val nombre: String
)