package com.wizelinebootcamp.bitcoinapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wizelinebootcamp.bitcoinapp.data.local.entities.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao : BaseDao<BookEntity> {

    @Query("SELECT * FROM book_table")
    suspend fun getAvailableBooks() : List<BookEntity>

    @Query("DELETE FROM book_table")
    suspend fun deleteAllBooks()

}