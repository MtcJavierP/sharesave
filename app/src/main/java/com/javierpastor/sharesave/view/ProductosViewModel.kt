package com.javierpastor.sharesave.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javierpastor.sharesave.bbdd.room.Item
import com.javierpastor.sharesave.bbdd.room.ItemDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class ProductViewModel @Inject constructor(private val itemDao: ItemDao) : ViewModel() {
//    val items = itemDao.getAll().asLiveData()
//}

@HiltViewModel
class ProductViewModel @Inject constructor(private val itemDao: ItemDao) : ViewModel() {
    private val _state = MutableStateFlow<List<Item>>(emptyList())
    val state: StateFlow<List<Item>> = _state

    init {
        viewModelScope.launch {
            itemDao.getAll().collect { items ->
                _state.value = items
            }
        }
    }
}