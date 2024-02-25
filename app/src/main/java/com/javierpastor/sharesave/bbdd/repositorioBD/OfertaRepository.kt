package com.javierpastor.sharesave.bbdd.repositorioBD

import android.content.ContentValues
import javax.inject.Inject


class OfertaRepository @Inject constructor(private val dbHelper: ItemDBHelper) {

    fun insert(oferta: Ofertas) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(ItemDBnormal.COLUMN_NAME, oferta.nombre)
            put(ItemDBnormal.COLUMN_PRICE, oferta.precio)
            put(ItemDBnormal.COLUMN_SUPERMARKET, oferta.supermercado)
        }
        db.insert(ItemDBnormal.TABLE_NAME, null, values)
    }

    fun getAll(): List<Ofertas> {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            ItemDBnormal.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        val ofertas = mutableListOf<Ofertas>()
        with(cursor) {
            while (moveToNext()) {
                val oferta = Ofertas(
                    getInt(getColumnIndexOrThrow(ItemDBnormal.COLUMN_ID)),
                    getString(getColumnIndexOrThrow(ItemDBnormal.COLUMN_NAME)),
                    getString(getColumnIndexOrThrow(ItemDBnormal.COLUMN_PRICE)),
                    getString(getColumnIndexOrThrow(ItemDBnormal.COLUMN_SUPERMARKET))
                )
                ofertas.add(oferta)
            }
        }
        return ofertas
    }
}