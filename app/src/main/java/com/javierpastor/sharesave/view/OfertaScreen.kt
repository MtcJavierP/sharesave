package com.javierpastor.sharesave.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.javierpastor.sharesave.bbdd.repositorioBD.Ofertas


//
//@Composable
//fun OfertaScreenContent(viewModel: OfertaViewModel) {
//    val items: List<Ofertas> by viewModel.ofertas.collectAsState(emptyList())
//
//    // Insertar datos de prueba al iniciar la pantalla
//    LaunchedEffect(key1 = true) {
//        viewModel.insert(Ofertas(0, "Leche Desnatada", "0.80", "Alcampo"))
//        viewModel.insert(Ofertas(0, "Aceite de Oliva", "7", "Eroski"))
//        viewModel.insert(Ofertas(0, "Aceite de Girasol", "3", "Carrefour"))
//    }
//
//    LazyColumn {
//        items(items) { item ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = item.nombre, modifier = Modifier.weight(1f))
//                Text(text = item.supermercado, modifier = Modifier.weight(1f))
//                Text(text = item.precio.toString(), modifier = Modifier.weight(1f))
//            }
//        }
//    }
//}
//

@Composable
fun OfertaScreenContent(viewModel: OfertaViewModel = hiltViewModel()) {
    val items by viewModel.ofertas.collectAsState()

    OfertaContent(items)
}

@Composable
fun OfertaContent(items: List<Ofertas>) {
    LazyColumn {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.nombre, modifier = Modifier.weight(1f))
                Text(text = item.supermercado, modifier = Modifier.weight(1f))
                Text(text = item.precio.toString(), modifier = Modifier.weight(1f))
            }
        }
    }
}

