package com.javierpastor.sharesave.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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
fun AddItemScreen(viewModel: AddItemViewModel = hiltViewModel(),navController: NavController) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var supermarket by remember { mutableStateOf("") }
    val context = LocalContext.current


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {



        Text(text = "Muchas gracias por compartir con la \n comunidad de ShareSave!", modifier = Modifier.padding(bottom = 16.dp))


        TextField(
            modifier=Modifier.padding(bottom = 8.dp),
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF8FBC8F),
                unfocusedContainerColor = Color(0xFF8FBC8F),
                disabledTextColor = Color(0xFFFFF8DC),
                focusedTextColor = Color(0xFFFFF8DC),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = { Text("Nombre producto") }
        )
        TextField(
            value = price,
            modifier=Modifier.padding(bottom = 8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF8FBC8F),
                unfocusedContainerColor = Color(0xFF8FBC8F),
                disabledTextColor = Color(0xFFFFF8DC),
                focusedTextColor = Color(0xFFFFF8DC),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = { price = it },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = supermarket,
            modifier=Modifier.padding(bottom = 8.dp),
            onValueChange = { supermarket = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF8FBC8F),
                unfocusedContainerColor = Color(0xFF8FBC8F),
                disabledTextColor = Color(0xFFFFF8DC),
                focusedTextColor = Color(0xFFFFF8DC),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = { Text("Supermercado") }
        )
        Button(onClick = {
            val priceAsDouble = price.toDoubleOrNull() ?: 0.0
            val item = Item(
                nombre = name,
                precio = priceAsDouble,
                supermercado = supermarket,

            )
            viewModel.insertItem(item)// esto es para insertar el item en la base de datos Room
            // Mostrar un mensaje de agradecimiento
            Toast.makeText(context, "Gracias por compartir!", Toast.LENGTH_SHORT).show()
            // Navegar de nuevo a la pantalla de inicio
            navController.navigate("home")
        }) {
            Text("Guardar")
        }
    }
}