package com.wizelinebootcamp.bitcoinapp.data.repository

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel

interface BitsoRepository {

    suspend fun getAvailableBooks(): BitsoApiResponse
    suspend fun getTicker(book: String): TickerModel
    suspend fun getOrderBook(book: String): OrderBookModel
}