package com.javierpastor.sharesave.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel


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
    val ciudadesState by viewModel.state.collectAsState( emptyList<String>())


    LazyColumn {
        items(ciudadesState) {
            Text(it)
        }
    }
}