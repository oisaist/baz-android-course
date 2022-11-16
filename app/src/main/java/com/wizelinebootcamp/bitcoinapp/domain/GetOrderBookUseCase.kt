package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.data.models.PayloadOrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import javax.inject.Inject

class GetOrderBookUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(book: String): PayloadOrderBookModel = repository.getOrderBook(book)
}
