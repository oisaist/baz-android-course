package com.wizelinebootcamp.bitcoinapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wizelinebootcamp.bitcoinapp.data.local.entities.OrderBookEntity

@Dao
interface OrderBookDao : BaseDao<OrderBookEntity> {

    @Query("SELECT * FROM order_book_table WHERE book = :book")
    suspend fun getOrderBook(book: String?) : OrderBookEntity?
}