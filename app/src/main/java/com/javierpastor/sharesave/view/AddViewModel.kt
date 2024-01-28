package com.javierpastor.sharesave.view

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor() : ViewModel(){

    var _state:List<Item> = emptyList()
    val state
    get() = _state

    init {
        _state= listOf(
        Item(
            name="Aceite de oliva Carbonell",
            price="9,5€",
            supermarket = "Eroski",
        ), Item(
            name="Aceite de oliva Abril",
            price="9€",
            supermarket = "Eroski"
        )
        )
    }


}


data class Item (
    val name: String,
    val price : String,
    val supermarket : String,

    )