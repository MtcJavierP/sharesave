package com.javierpastor.sharesave.view

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel




@Composable
fun  AddItemScreen(viewModel: AddItemViewModel = hiltViewModel()) {
    val state = viewModel.state

}

