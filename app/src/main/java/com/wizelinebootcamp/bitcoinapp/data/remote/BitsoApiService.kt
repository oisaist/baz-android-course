package com.wizelinebootcamp.bitcoinapp.data.remote

import com.wizelinebootcamp.bitcoinapp.core.Constants
import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BitsoApiService {

    @GET(Constants.AVAILABLE_BOOKS)
    suspend fun getAvailableBooks(): BitsoApiResponse

    @GET(Constants.TICKER)
    fun getTicker(@Query("book") book: String): Observable<TickerModel>

    @GET(Constants.ORDER_BOOK)
    suspend fun getOrderBook(@Query("book") book: String): OrderBookModel?
}
