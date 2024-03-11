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
import com.javierpastor.sharesave.bbdd.room.Item

@Composable
fun ProductScreenContent(viewModel: ProductViewModel = hiltViewModel()) {
    val items by viewModel.state.collectAsState()

    ProductContent(items)


}

@Composable
fun ProductContent(items: List<Item>) {

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




