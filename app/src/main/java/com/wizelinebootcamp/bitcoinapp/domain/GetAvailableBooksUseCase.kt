package com.wizelinebootcamp.bitcoinapp.domain

import android.util.Log
import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class GetAvailableBooksUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(): Flow<NetworkResponse<BitsoApiResponse>> = flow {
        try {
            emit(NetworkResponse.Loading())
            val availableBooks = repository.getAvailableBooks()
            emit(NetworkResponse.Success(availableBooks))
        } catch (e: HttpException) {
            emit(NetworkResponse.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(NetworkResponse.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}