package com.javierpastor.sharesave.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.javierpastor.sharesave.retrofit.CiudadAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
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
    val ciudades = flow {
        try {
            val data = ciudadAPI.getCiudades()
            Log.d("CiudadViewModel", data.toString())  // Imprime los datos en Logcat
            emit(data)
        } catch (e: Exception) {
            e.printStackTrace()  // Imprime el error en la consola
        }
    }.asLiveData(Dispatchers.IO)
}