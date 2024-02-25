package com.javierpastor.sharesave.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javierpastor.sharesave.bbdd.room.Item
import com.javierpastor.sharesave.bbdd.room.ItemDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class AddItemViewModel @Inject constructor(private val itemDao: ItemDao) : ViewModel(){
//
//    var _state:List<Item> = emptyList()
//    val state
//    get() = _state
//
//    init {
//        _state= listOf(
//        Item(
//            name="Aceite de oliva Carbonell",
//            price="9,5€",
//            supermarket = "Eroski",
//        ), Item(
//            name="Aceite de oliva Abril",
//            price="9€",
//            supermarket = "Eroski"
//        )
//        )
//        println("Cantidad de elementos en _state: ${_state.size}")
//    }
//    fun insertItem(item: Item) = viewModelScope.launch {
//        itemDao.insert(item)
//    }
//
//}

//Metodo modificado para que se pueda inyectar en cualquier parte de la aplicacion y
// poder meter datos en la base de datos room
@HiltViewModel
class AddItemViewModel @Inject constructor(private val itemDao: ItemDao) : ViewModel(){

    var _state:List<Item> = emptyList()
    val state
        get() = _state


    fun insertItem(item: Item) = viewModelScope.launch {
        itemDao.insert(item)
    }
}

data class Item (
    val name: String,
    val price : String,
    val supermarket : String,

    )