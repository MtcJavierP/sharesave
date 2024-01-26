package com.javierpastor.sharesave

sealed class Router(val route: String) {
    object Home : Router("Home")
    object Pantalla2 : Router("Pantalla2")
}
