package com.wizelinebootcamp.bitcoinapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wizelinebootcamp.bitcoinapp.data.local.entities.BookEntity

@Dao
interface BookDao : BaseDao<BookEntity> {

    @Query("SELECT * FROM book_table")
    suspend fun getAvailableBooks(): List<BookEntity>

    @Query("DELETE FROM book_table")
    suspend fun deleteAllBooks()
}
