package com.javierpastor.sharesave

sealed class Router(val route: String) {
    object Home : Router("Home")
    object AddItem : Router("AddItem")

    object Supermarkets : Router("Supermarkets")

    object Products : Router("Products")
    object Offers : Router("Offers")


}


