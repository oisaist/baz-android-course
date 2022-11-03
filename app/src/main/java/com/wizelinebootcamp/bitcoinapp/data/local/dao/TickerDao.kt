package com.wizelinebootcamp.bitcoinapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wizelinebootcamp.bitcoinapp.data.local.entities.TickerEntity

@Dao
interface TickerDao : BaseDao<TickerEntity> {

    @Query("SELECT * FROM ticker_table WHERE book = :book")
    suspend fun getTicker(book: String?) : TickerEntity?
}