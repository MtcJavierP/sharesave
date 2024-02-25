package com.javierpastor.sharesave.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.javierpastor.sharesave.bbdd.room.ItemDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val itemDao: ItemDao) : ViewModel() {
    val items = itemDao.getAll().asLiveData()
}