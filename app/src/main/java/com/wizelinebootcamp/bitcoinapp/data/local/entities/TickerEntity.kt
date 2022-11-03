package com.wizelinebootcamp.bitcoinapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wizelinebootcamp.bitcoinapp.core.Constants

@Entity(tableName = Constants.TICKER_TABLE)
data class TickerEntity(
    @PrimaryKey @ColumnInfo(name = "book") val book: String = "",
    @ColumnInfo(name = "high") val high: String? = "",
    @ColumnInfo(name = "last") val last: String? = "",
    @ColumnInfo(name = "created_at") val created_at: String? = "",
    @ColumnInfo(name = "volume") val volume: String? = "",
    @ColumnInfo(name = "vwap") val vwap: String? = "",
    @ColumnInfo(name = "low") val low: String? = "",
    @ColumnInfo(name = "ask") val ask: String? = "",
    @ColumnInfo(name = "bid") val bid: String? = "",
    @ColumnInfo(name = "change_24") val change_24: String? = ""
)
