package com.wizelinebootcamp.bitcoinapp.data.local

import com.wizelinebootcamp.bitcoinapp.data.local.dao.BookDao
import com.wizelinebootcamp.bitcoinapp.data.local.dao.OrderBookDao
import com.wizelinebootcamp.bitcoinapp.data.local.dao.TickerDao
import com.wizelinebootcamp.bitcoinapp.data.local.entities.BookEntity
import com.wizelinebootcamp.bitcoinapp.data.local.entities.OrderBookEntity
import com.wizelinebootcamp.bitcoinapp.data.local.entities.TickerEntity
import io.reactivex.Observable
import javax.inject.Inject

class LocalBookDataSource @Inject constructor(
    private val bookDao: BookDao,
    private val tickerDao: TickerDao,
    private val orderBookDao: OrderBookDao
) {

    // availableBooks
    suspend fun getAvailableBooks(): List<BookEntity> = bookDao.getAvailableBooks()
    suspend fun insertBookList(bookList: List<BookEntity>) = bookDao.insertList(bookList)
    suspend fun deleteAllBooks() = bookDao.deleteAllBooks()

    // ticker
    fun getTicker(book: String): Observable<TickerEntity?> = tickerDao.getTicker(book)
    suspend fun insertTicker(ticker: TickerEntity) = tickerDao.insertObj(ticker)

    // orderBook
    suspend fun getOrderBook(book: String) = orderBookDao.getOrderBook(book)
    suspend fun insertOrderBook(orderBook: OrderBookEntity) = orderBookDao.insertObj(orderBook)
}
