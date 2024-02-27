package com.javierpastor.sharesave.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CiudadScreenContent(viewModel: CiudadViewModel = viewModel()) {
    val ciudades by viewModel.ciudades.observeAsState(emptyList())

    LazyColumn {
        items(ciudades) { ciudad ->
            Text(ciudad.nombre ?: "Nombre no disponible")        }
    }
}