package com.wizelinebootcamp.bitcoinapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wizelinebootcamp.bitcoinapp.data.local.entities.TickerEntity
import io.reactivex.Observable

@Dao
interface TickerDao : BaseDao<TickerEntity> {

    @Query("SELECT * FROM ticker_table WHERE book = :book")
    fun getTicker(book: String?): Observable<TickerEntity?>
}
