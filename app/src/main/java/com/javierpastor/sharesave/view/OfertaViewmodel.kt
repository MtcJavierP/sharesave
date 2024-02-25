package com.javierpastor.sharesave.view


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.javierpastor.sharesave.bbdd.repositorioBD.OfertaRepository
import com.javierpastor.sharesave.bbdd.repositorioBD.Ofertas
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OfertaViewModel @Inject constructor(private val repository: OfertaRepository) : ViewModel() {
    val ofertas = MutableLiveData<List<Ofertas>>()

    init {
        ofertas.value = repository.getAll()
    }

    fun insert(oferta: Ofertas) {
        repository.insert(oferta)
        ofertas.value = repository.getAll()
    }
}