package com.javierpastor.sharesave.view

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javierpastor.sharesave.R
import com.javierpastor.sharesave.model.SuperMercados
import kotlinx.coroutines.launch


@Composable
fun SupermercadosScreenContent() {
    val context = LocalContext.current
    val rvState = rememberLazyListState() //esto es para recordar el estado de la lista
    val coroutinesScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Supermercados", modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally), fontSize = 24.sp,fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline)
        Spacer(modifier = Modifier.padding(16.dp))
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(getSuperMercados()) { supermercado ->
                ItemSupermercado(supermercado = supermercado)
                { Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show() }

            }
        }
        val showbutton by remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }
        //esto es para saber si se muestra el botón o no, en este caso se muestra si el primer item que se muestra es mayor que 0
        //por lo que al scrollear hacia abajo, se mostrará el botón, al acabar el primer item

        rvState.firstVisibleItemScrollOffset //nos da un valor del offset del primer item que se muestra
        //nos vale para saber que si el numero es myor que el anterior, es que se ha scrolleado hacia abajo

        if (showbutton) {
            Button(
                onClick = {coroutinesScope.launch { rvState.animateScrollToItem(0) }  }, //esto tendria que ir en una
                //funcion suspendida, para eso creamos una corutina arriba
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Volver al inicio")
            }
        }

    }
}

@Composable
fun ItemSupermercado(supermercado: SuperMercados, onItemSelected: (SuperMercados) -> Unit = {}) {
    val context = LocalContext.current

    Card(border = BorderStroke(2.dp, Color(0xFF8FBC8F)),modifier= Modifier
        .width(300.dp)//.padding(8.dp) este padding seria para el GridView
        .clickable { onItemSelected(supermercado) }) {
        Column (Modifier.align(Alignment.CenterHorizontally)){
            Image(
                painter = painterResource(id = supermercado.image),
                contentDescription = "supermercado avatar",
                contentScale = ContentScale.Crop, //para que la imagen se ajuste al tamaño del contenedor
                modifier = Modifier.fillMaxWidth(),
            )
            Text(text = supermercado.name, modifier=Modifier.align(Alignment.CenterHorizontally))
            //ahora ponemos la web
            Text(
                text = "LINK",
                color = Color.Blue,
                modifier = Modifier
                    .clickable {
                        val uri = Uri.parse(supermercado.website)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    }
                    .align(Alignment.CenterHorizontally)
            )

        }


    }
}





fun getSuperMercados(): List<SuperMercados> {
    return listOf( //este es el listado de supermercados
        SuperMercados("Mercadona", "https://www.mercadona.es/", R.drawable.mercadona),
        SuperMercados("Carrefour", "https://www.carrefour.es/", R.drawable.carrefour),
        SuperMercados("Lidl", "https://www.lidl.es/", R.drawable.lidl),
        SuperMercados("Gadis", "https://www.gadis.es/", R.drawable.gadis),
        SuperMercados("Dia", "https://www.dia.es/", R.drawable.dia),
        SuperMercados("Alcampo", "https://www.compraonline.alcampo.es/", R.drawable.alcampo),
    )
}