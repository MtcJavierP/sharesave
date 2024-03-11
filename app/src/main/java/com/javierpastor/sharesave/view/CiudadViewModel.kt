package com.javierpastor.sharesave.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javierpastor.sharesave.retrofit.CiudadAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//class CiudadViewModel(private val ciudadAPI: CiudadAPI = RetrofitInstance.ciudadAPI) : ViewModel() {
//    val ciudades = liveData(Dispatchers.IO) {
//        try {
//            val result = ciudadAPI.getCiudades()
//            emit(result)
//        } catch (e: Exception) {
//            Log.e("CiudadViewModel", "Error al obtener ciudades", e)
//        }
//    }
//}


@HiltViewModel
class CiudadViewModel @Inject constructor(private val ciudadAPI: CiudadAPI) : ViewModel() {

    var _state= MutableStateFlow(emptyList<String>())
    val state=_state

    init {
        viewModelScope.launch {
             _state.value=ciudadAPI.getCiudades().map {
                 ciudad ->
                    ciudad.nombre
                }
            }
        }
    }




