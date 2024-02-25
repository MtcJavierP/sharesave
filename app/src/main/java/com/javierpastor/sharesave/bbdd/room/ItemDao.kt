package com.javierpastor.sharesave.bbdd.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM productos")
    fun getAll(): List<Item>

    @Insert
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)
}