package com.wizelinebootcamp.bitcoinapp.data.local.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wizelinebootcamp.bitcoinapp.core.Constants
import com.wizelinebootcamp.bitcoinapp.data.models.BidAskModel

@Entity(tableName = Constants.ORDER_BOOK_TABLE)
data class OrderBookEntity (
    @PrimaryKey @ColumnInfo( name = "book") val book: String,
    @ColumnInfo(name = "updated_at") val updated_at: String? = "",
    @ColumnInfo(name = "bids") val bids: List<BidAskModel>? = emptyList(),
    @ColumnInfo(name = "asks") val asks: List<BidAskModel>? = emptyList()
        )
