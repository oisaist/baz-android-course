package com.wizelinebootcamp.bitcoinapp.data.local

import com.wizelinebootcamp.bitcoinapp.data.local.entities.BookEntity
import com.wizelinebootcamp.bitcoinapp.data.local.entities.OrderBookEntity
import com.wizelinebootcamp.bitcoinapp.data.local.entities.TickerEntity
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadOrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel

fun PayloadModel.toBookEntity() = BookEntity(
    book = book ?: "",
    minimum_price = minimum_price ?: "",
    maximum_price = maximum_price ?: "",
    minimum_amount = minimum_amount ?: "",
    maximum_amount = maximum_amount ?: "",
    minimum_value = minimum_value ?: "",
    maximum_value = maximum_value ?: "",
    tick_size = tick_size ?: "",
    default_chart = default_chart ?: "",
    bookName = bookName ?: ""
)

fun List<PayloadModel>.toBookListEntity() = this.map { it.toBookEntity() }

fun BookEntity.toPayloadModel() = PayloadModel(
    book = book,
    minimum_price = minimum_price,
    maximum_price = maximum_price,
    minimum_amount = minimum_amount,
    maximum_amount = maximum_amount,
    minimum_value = minimum_value,
    maximum_value = maximum_value,
    tick_size = tick_size,
    default_chart = default_chart,
    bookName = bookName
)

fun List<BookEntity>.toPayloadListModel() = this.map { it.toPayloadModel() }

fun PayloadTickerModel.toTickerEntity() = TickerEntity(
    book = book ?: "",
    high = high ?: "",
    last = last ?: "",
    created_at = created_at ?: "",
    volume = volume ?: "",
    vwap = vwap ?: "",
    low = low ?: "",
    ask = ask ?: "",
    bid = bid ?: "",
    change_24 = change_24 ?: ""
)

fun TickerEntity.toPayloadTickerModel() = PayloadTickerModel(
    high = high,
    last = last,
    created_at = created_at,
    book = book,
    volume = volume,
    vwap = vwap,
    low = low,
    ask = ask,
    bid = bid,
    change_24 = change_24
)

fun PayloadOrderBookModel.toOrderBookEntity(book: String?) = OrderBookEntity(
    book = book ?: "",
    updated_at = updated_at ?: "",
    bids = bids ?: listOf(),
    asks = asks ?: listOf()
)

fun OrderBookEntity.toPayloadOrderBookModel() = PayloadOrderBookModel(
    updated_at = updated_at,
    bids = bids,
    asks = asks
)
