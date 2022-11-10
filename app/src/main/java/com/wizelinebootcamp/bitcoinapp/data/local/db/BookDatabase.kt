package com.wizelinebootcamp.bitcoinapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wizelinebootcamp.bitcoinapp.data.local.OrderBookTypeConverter
import com.wizelinebootcamp.bitcoinapp.data.local.dao.BookDao
import com.wizelinebootcamp.bitcoinapp.data.local.dao.OrderBookDao
import com.wizelinebootcamp.bitcoinapp.data.local.dao.TickerDao
import com.wizelinebootcamp.bitcoinapp.data.local.entities.BookEntity
import com.wizelinebootcamp.bitcoinapp.data.local.entities.OrderBookEntity
import com.wizelinebootcamp.bitcoinapp.data.local.entities.TickerEntity

@Database(
    entities = [BookEntity::class, TickerEntity::class, OrderBookEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(OrderBookTypeConverter::class)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao() : BookDao
    abstract fun tickerDao() : TickerDao
    abstract fun orderBookDao() : OrderBookDao
}