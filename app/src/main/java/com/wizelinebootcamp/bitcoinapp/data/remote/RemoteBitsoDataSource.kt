package com.wizelinebootcamp.bitcoinapp.data.remote

import android.util.Log
import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import javax.inject.Inject

class RemoteBitsoDataSource @Inject constructor(
    private val apiService: BitsoApiService
) {

    suspend fun getAvailableBooks(): BitsoApiResponse {
        val result = apiService.getAvailableBooks()
        result.payload.forEach { coin ->
            val bookName = coin.book?.split("_")
            coin.bookName = bookName?.get(0)
        }
        result.payload.forEach { it.bookName?.let { it1 -> Log.e("CryptoApp", it1) } }
        return result
    }
    suspend fun getTicker(book: String): TickerModel = apiService.getTicker(book)
    suspend fun getOrderBook(book: String): OrderBookModel = apiService.getOrderBook(book)

}