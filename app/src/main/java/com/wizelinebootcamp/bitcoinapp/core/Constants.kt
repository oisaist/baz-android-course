package com.wizelinebootcamp.bitcoinapp.core

class Constants {

    companion object {
        //baseUrl
        const val BASE_URL = "https://api.bitso.com/v3/"

        //endpoints
        const val AVAILABLE_BOOKS = "available_books/"
        const val TICKER = "ticker/"
        const val ORDER_BOOK = "order_book/"

        //room
        const val CRYPTO_CURRENCY_DATABASE = "crypto_currency_db"
        const val BOOK_TABLE = "book_table"
        const val TICKER_TABLE = "ticker_table"
        const val ORDER_BOOK_TABLE = "order_book_table"
    }
}