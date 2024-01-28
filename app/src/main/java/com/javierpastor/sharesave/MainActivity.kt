package com.javierpastor.sharesave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javierpastor.sharesave.ui.theme.SharesaveTheme
import com.javierpastor.sharesave.view.HomeContent
import com.javierpastor.sharesave.view.AddItem
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharesaveTheme {

                val navController = rememberNavController()
                // val home = Home(navController)

                NavHost(
                    navController = navController,
                    startDestination = Router.Home.route
                ) {
                    composable(Router.Home.route) {
                        HomeContent(navController)
                    }
                    //Definimos la segunda pantalla
                    composable(Router.AddItem.route){

                        AddItem()
                    }

                }





                // A surface container using the 'background' color from the theme
                /**   Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
                ) {
                //  Greeting("Android")
                // ScaffoldExample()

                }**/
            }
        }
    }
}
/** DEJO ESTE CODIGO, PERO LO TRASLADO A HOME PARA HACER UN NAVCONTROLLER
 *
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
Text(
text = "Hello $name!",
modifier = modifier
)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
SharesaveTheme {
Greeting("Android")

}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
var presses by remember { mutableIntStateOf(0) }

Scaffold(
topBar = {
TopAppBar(
colors = topAppBarColors(
containerColor = MaterialTheme.colorScheme.primaryContainer,
titleContentColor = MaterialTheme.colorScheme.primary,
),
title = {
Text(
text="Share",
modifier= Modifier.fillMaxWidth(),
textAlign = TextAlign.Center
)
} //title
)
}, //topbar
bottomBar = {
BottomAppBar(
containerColor = MaterialTheme.colorScheme.primaryContainer,
contentColor = MaterialTheme.colorScheme.primary,
) {
Text(
modifier = Modifier
.fillMaxWidth(),
textAlign = TextAlign.Center,
text = "Save",
)
}
},
floatingActionButton = {
FloatingActionButton(onClick = { presses++ }) {
Icon(Icons.Default.Add, contentDescription = "Add")
}
}
) { innerPadding ->
Column(
modifier = Modifier
.padding(innerPadding),
verticalArrangement = Arrangement.spacedBy(16.dp),
) {
Text(
modifier = Modifier.padding(8.dp),
text =
"""
Bienvenidos a Share & Save! Por favor, compartid vuestras gangas
en los distintos supermercados con el resto de usuarios para que
toda la comunidad pueda ahorrar!

Has presionado el boton $presses veces.
""".trimIndent(),


) //text

Image(
painter = painterResource(id = R.drawable.monedas), // Reemplaza con el ID de tu imagen
contentDescription = null,
modifier = Modifier
.fillMaxWidth()
.height(200.dp) // Ajusta la altura según sea necesario
.clip(shape = MaterialTheme.shapes.medium)
) //imagen

LazyColumn {
items(listOf("-  Supermercados", "-  Ofertas", "-  Productos", "-  Ciudad")) { item ->
Text(
text = item,
modifier = Modifier
.padding(8.dp)
.clickable {
// Lógica para manejar el clic en el elemento
// Puedes navegar a otra pantalla, realizar alguna acción, etc.
// Por ahora, puedes imprimir un mensaje en la consola
println("Elemento clickeado: $item")

}
)
}//listof
}//lazy column
}
}
}**/
