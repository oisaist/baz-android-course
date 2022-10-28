package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAvailableBooksUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(): Flow<BitsoApiResponse> = flow {
        val availableBooks = repository.getAvailableBooks()
        emit(availableBooks)
    }
}