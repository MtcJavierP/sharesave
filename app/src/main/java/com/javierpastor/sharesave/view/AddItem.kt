package com.javierpastor.sharesave.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun  AddItemScreen(viewModel: AddItemViewModel = hiltViewModel()) {

    val state = viewModel.state

}

