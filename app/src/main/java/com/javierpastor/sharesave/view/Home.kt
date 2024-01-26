package com.javierpastor.sharesave

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@ExperimentalMaterial3Api
class Home(private val navController: NavHostController) {

    @Composable
    fun HomeContent(navController: NavController) {
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
                            text = "Share",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    } //title
                )
            },
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
                FloatingActionButton(onClick = { navController.navigate(Router.Pantalla2.route) }) {
                    Text(text = "Ir a Pantalla 2")
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

                        Has presionado el botón $presses veces.
                    """.trimIndent(),
                ) //text

                Image(
                    painter = painterResource(id = R.drawable.monedas),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                ) //imagen

                LazyColumn {
                    items(listOf("-  Supermercados", "-  Ofertas", "-  Productos", "-  Ciudad")) { item ->
                        Text(
                            text = item,
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    println("Elemento clickeado: $item")
                                }
                        )
                    }//listof
                }//lazy column
            }
        }
    }
    fun navigateToHome() {
        navController.navigate(Router.Home.route)
    }
}





/**
    @Composable
    fun HomeContent() {
        ScaffoldExample()
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
                            text = "Share",
                            modifier = Modifier.fillMaxWidth(),
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
                FloatingActionButton(onClick = { navController.navigate(Router.Pantalla2.route) }) {
                    Text(text = "Ir a Pantalla 2")
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

                        Has presionado el botón $presses veces.
                    """.trimIndent(),
                ) //text

                Image(
                    painter = painterResource(id = R.drawable.monedas),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                ) //imagen

                LazyColumn {
                    items(listOf("-  Supermercados", "-  Ofertas", "-  Productos", "-  Ciudad")) { item ->
                        Text(
                            text = item,
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    println("Elemento clickeado: $item")
                                }
                        )
                    }//listof
                }//lazy column
            }
        }
    }

    fun navigateToHome() {
        navController.navigate(Router.Home.route)
    }
}
**/