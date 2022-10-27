package com.wizelinebootcamp.bitcoinapp.data.remote

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import javax.inject.Inject

class RemoteBitsoDataSource @Inject constructor(
    private val apiService: BitsoApiService
) {

    suspend fun getAvailableBooks(): BitsoApiResponse = apiService.getAvailableBooks()
    suspend fun getTicker(book: String): TickerModel = apiService.getTicker(book)
    suspend fun getOrderBook(book: String): OrderBookModel = apiService.getOrderBook(book)

}