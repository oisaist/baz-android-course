package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTickerUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(book: String): PayloadTickerModel = repository.getTicker(book)
}