package com.javierpastor.sharesave.bbdd.room


import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemDao: ItemDao) {

    val allItems: Flow<List<Item>> = itemDao.getAll()

    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

    suspend fun delete(item: Item) {
        itemDao.delete(item)
    }
}