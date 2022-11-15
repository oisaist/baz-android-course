package com.wizelinebootcamp.bitcoinapp.data.repository

import android.annotation.SuppressLint
import com.wizelinebootcamp.bitcoinapp.core.CheckInternetConnection
import com.wizelinebootcamp.bitcoinapp.data.local.*
import com.wizelinebootcamp.bitcoinapp.data.models.*
import com.wizelinebootcamp.bitcoinapp.data.remote.RemoteBitsoDataSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("CheckResult")
    override suspend fun getTicker(book: String): Observable<PayloadTickerModel> {
        return if (CheckInternetConnection.isNetworkAvailable()) {
            remoteBitsoDataSource.getTicker(book)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { tickerModel ->
                    GlobalScope.launch {
                        localBookDataSource.insertTicker(tickerModel.payload!!.toTickerEntity())
                    }
                }
            remoteBitsoDataSource.getTicker(book).map { it.payload }
        } else {
            localBookDataSource.getTicker(book).map { it.toPayloadTickerModel() }
        }
    }

    override suspend fun getOrderBook(book: String): PayloadOrderBookModel {
        return if (CheckInternetConnection.isNetworkAvailable()) {
            val orderBook = remoteBitsoDataSource.getOrderBook(book)?.payload
            localBookDataSource.insertOrderBook(orderBook!!.toOrderBookEntity(book))
            remoteBitsoDataSource.getOrderBook(book)?.payload ?: PayloadOrderBookModel()
        } else {
            localBookDataSource.getOrderBook(book)?.toPayloadOrderBookModel()
                ?: PayloadOrderBookModel()
        }
    }
}