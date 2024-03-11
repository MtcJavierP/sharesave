package com.javierpastor.sharesave.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javierpastor.sharesave.bbdd.repositorioBD.OfertaRepository
import com.javierpastor.sharesave.bbdd.repositorioBD.Ofertas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
//class OfertaViewModel @Inject constructor(private val repository: OfertaRepository) : ViewModel() {
//    val ofertas = MutableLiveData<List<Ofertas>>()
//
//    init {
//        ofertas.value = repository.getAll()
//    }
//
//    fun insert(oferta: Ofertas) {
//        repository.insert(oferta)
//        ofertas.value = repository.getAll()
//    }
//}


@HiltViewModel
class OfertaViewModel @Inject constructor(private val repository: OfertaRepository) : ViewModel() {
    private val _ofertas = MutableStateFlow<List<Ofertas>>(emptyList())
    val ofertas: StateFlow<List<Ofertas>> = _ofertas

    init {
        viewModelScope.launch {
            _ofertas.value = repository.getAll()
        }
    }

    fun insert(oferta: Ofertas) = viewModelScope.launch {
        repository.insert(oferta)
        _ofertas.value = repository.getAll()
    }
}