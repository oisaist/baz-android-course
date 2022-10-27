package com.wizelinebootcamp.bitcoinapp.domain

import android.util.Log
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetOrderBookUseCase @Inject constructor(
    private val repository: BitsoRepository
){

    suspend operator fun invoke(book: String): Flow<OrderBookModel> = flow {
        val orderBook = repository.getOrderBook(book)
        emit(orderBook)
    }
}