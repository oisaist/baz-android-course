package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTickerUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(book: String): Observable<PayloadTickerModel> =
        repository.getTicker(book)
}
