package com.wizelinebootcamp.bitcoinapp.data.repository

import com.wizelinebootcamp.bitcoinapp.core.CheckInternetConnection
import com.wizelinebootcamp.bitcoinapp.data.local.*
import com.wizelinebootcamp.bitcoinapp.data.models.*
import com.wizelinebootcamp.bitcoinapp.data.remote.RemoteBitsoDataSource
import javax.inject.Inject

class BitsoRepositoryImpl @Inject constructor(
    private val remoteBitsoDataSource: RemoteBitsoDataSource,
    private val localBookDataSource: LocalBookDataSource
) : BitsoRepository {

    override suspend fun getAvailableBooks(): List<PayloadModel> {
        if (CheckInternetConnection.isNetworkAvailable()) {
            localBookDataSource.deleteAllBooks()
            val bookList = remoteBitsoDataSource.getAvailableBooks().payload
            localBookDataSource.insertBookList(bookList.toBookListEntity())
        }
        return localBookDataSource.getAvailableBooks().toPayloadListModel()
    }

    override suspend fun getTicker(book: String): PayloadTickerModel {
        return if (CheckInternetConnection.isNetworkAvailable()) {
            val ticker = remoteBitsoDataSource.getTicker(book).payload
            localBookDataSource.insertTicker(ticker!!.toTickerEntity())
            remoteBitsoDataSource.getTicker(book).payload ?: PayloadTickerModel()
        } else {

            localBookDataSource.getTicker(book)?.toPayloadTickerModel() ?: PayloadTickerModel()
        }
    }

    override suspend fun getOrderBook(book: String): PayloadOrderBookModel {
        return if (CheckInternetConnection.isNetworkAvailable()) {
            val orderBook = remoteBitsoDataSource.getOrderBook(book).payload
            localBookDataSource.insertOrderBook(orderBook.toOrderBookEntity(book))
            remoteBitsoDataSource.getOrderBook(book).payload
            //return localBookDataSource.getOrderBook(book)?.toPayloadOrderBookModel() ?: OrderBookEntity(book).toPayloadOrderBookModel()
        } else {
            localBookDataSource.getOrderBook(book)?.toPayloadOrderBookModel() ?: PayloadOrderBookModel()
        }
    }
}