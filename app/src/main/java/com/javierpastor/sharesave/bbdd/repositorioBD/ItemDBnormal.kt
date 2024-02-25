package com.javierpastor.sharesave.bbdd.repositorioBD


//esta BBDD la usare para las Ofertas
object ItemDBnormal {
    const val TABLE_NAME = "item"
    const val COLUMN_NAME = "name"
    const val COLUMN_PRICE = "price"
    const val COLUMN_SUPERMARKET = "supermarket"
    const val COLUMN_ID = "id"

    const val SQL_CREATE_ENTRIES = """
        CREATE TABLE $TABLE_NAME (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_NAME TEXT,
            $COLUMN_PRICE TEXT,
            $COLUMN_SUPERMARKET TEXT
        )
    """

    private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
}