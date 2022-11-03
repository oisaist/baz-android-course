package com.wizelinebootcamp.bitcoinapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wizelinebootcamp.bitcoinapp.core.Constants

@Entity(tableName = Constants.BOOK_TABLE)
data class BookEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "bookId") val bookId: Int = 0,
    @ColumnInfo(name = "book") val book: String,
    @ColumnInfo(name = "minimum_price") val minimum_price: String,
    @ColumnInfo(name = "maximum_price") val maximum_price: String,
    @ColumnInfo(name = "minimum_amount") val minimum_amount: String,
    @ColumnInfo(name = "maximum_amount") val maximum_amount: String,
    @ColumnInfo(name = "minimum_value") val minimum_value: String,
    @ColumnInfo(name = "maximum_value") val maximum_value: String,
    @ColumnInfo(name = "tick_size") val tick_size: String,
    @ColumnInfo(name = "default_chart") val default_chart: String,
    @ColumnInfo(name = "bookName") val bookName: String ,
)