package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.core.NetworkResponse
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAvailableBooksUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(): Flow<NetworkResponse<List<PayloadModel>>> = flow {
        try {
            emit(NetworkResponse.Loading())
            val availableBooks = repository.getAvailableBooks()
            emit(NetworkResponse.Success(availableBooks))
        } catch (e: Exception) {
            emit(NetworkResponse.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}
