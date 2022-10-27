package com.wizelinebootcamp.bitcoinapp.data.repository

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import com.wizelinebootcamp.bitcoinapp.data.remote.RemoteBitsoDataSource
import javax.inject.Inject

class BitsoRepositoryImpl @Inject constructor(
    private val remoteBitsoDataSource: RemoteBitsoDataSource
): BitsoRepository {

    override suspend fun getAvailableBooks(): BitsoApiResponse = remoteBitsoDataSource.getAvailableBooks()
    override suspend fun getTicker(book: String): TickerModel = remoteBitsoDataSource.getTicker(book)
    override suspend fun getOrderBook(book: String): OrderBookModel = remoteBitsoDataSource.getOrderBook(book)
}