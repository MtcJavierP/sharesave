package com.javierpastor.sharesave.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.javierpastor.sharesave.bbdd.room.Item


/*
@Composable
fun  AddItemScreen(viewModel: AddItemViewModel = hiltViewModel()) {
    var currentItemIndex by remember { mutableStateOf(0) }
    val state = viewModel.state

    println("Cantidad de elementos en state: ${state.size}")

    LazyColumn {
        item {
            Text(text = "Nombre del artículo: ${state[currentItemIndex].name}")
            Text(text = "Precio: ${state[currentItemIndex].price}")
            Text(text = "Supermercado: ${state[currentItemIndex].supermarket}")
        }

        item {
            Button(onClick = {
                // Asegurarse de que no excedamos el índice máximo
                currentItemIndex = (currentItemIndex + 1).coerceAtMost(state.size - 1)
            }) {
                Text(text = "Siguiente artículo")
            }
        }

        item {
            Button(onClick = {
                // Asegurarse de que no bajemos del índice mínimo
                currentItemIndex = (currentItemIndex - 1).coerceAtLeast(0)
            }) {
                Text(text = "Artículo anterior")
            }
        }
    }

}

*/
@Composable
fun AddItemScreen(viewModel: AddItemViewModel = hiltViewModel()) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var supermarket by remember { mutableStateOf("") }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") }
        )
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = supermarket,
            onValueChange = { supermarket = it },
            label = { Text("Supermercado") }
        )
        Button(onClick = {
            val priceAsDouble = price.toDoubleOrNull() ?: 0.0
            val item = Item(
                nombre = name,
                precio = priceAsDouble,
                supermercado = supermarket
            )
            viewModel.insertItem(item)
        }) {
            Text("Guardar")
        }
    }
}