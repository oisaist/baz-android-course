package com.wizelinebootcamp.bitcoinapp.data.repository

import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadOrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel
import io.reactivex.Observable

interface BitsoRepository {

    suspend fun getAvailableBooks(): List<PayloadModel>
    suspend fun getTicker(book: String): Observable<PayloadTickerModel>
    suspend fun getOrderBook(book: String): PayloadOrderBookModel
}