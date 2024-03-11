package com.javierpastor.sharesave.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.javierpastor.sharesave.retrofit.Ciudad


//@Composable
//fun CiudadScreenContent(viewModel: CiudadViewModel = viewModel()) {
//    val ciudades by viewModel.ciudades.observeAsState(emptyList())
//
//    LazyColumn {
//        items(ciudades) { ciudad ->
//            Text(ciudad.nombre ?: "Nombre no disponible")        }
//    }
//}

@Composable
fun CiudadScreenContent(viewModel: CiudadViewModel = hiltViewModel()) {
    val ciudadesState by viewModel.ciudades.observeAsState(initial = emptyList<Ciudad>())
    val ciudades = ciudadesState ?: emptyList()

    LazyColumn {
        itemsIndexed(ciudades) { index, ciudad ->
            Text(ciudad.nombre ?: "Nombre no disponible")
        }
    }
}