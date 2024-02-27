package com.javierpastor.sharesave.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.javierpastor.sharesave.retrofit.CiudadAPI
import com.javierpastor.sharesave.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers

class CiudadViewModel(private val ciudadAPI: CiudadAPI = RetrofitInstance.ciudadAPI) : ViewModel() {
    val ciudades = liveData(Dispatchers.IO) {
        try {
            val result = ciudadAPI.getCiudades()
            emit(result)
        } catch (e: Exception) {
            Log.e("CiudadViewModel", "Error al obtener ciudades", e)
        }
    }
}