package com.wizelinebootcamp.bitcoinapp.domain

import android.util.Log
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTickerUseCase @Inject constructor(
    private val repository: BitsoRepository
) {

    suspend operator fun invoke(book: String): Flow<TickerModel> = flow {
        try {
            val ticker = repository.getTicker(book)
            emit(ticker)
        } catch (e: HttpException) {
            Log.d("GetTickerUseCase", "${e.code()} + ${e.localizedMessage}")
        } catch (e: IOException) {
            Log.d("GetTickerUseCase", e.localizedMessage ?: "An error unexpected occurred")
        }
    }
}