package com.wizelinebootcamp.bitcoinapp.data.remote

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteBitsoDataSource @Inject constructor(
    private val apiService: BitsoApiService
) {

    suspend fun getAvailableBooks(): BitsoApiResponse = apiService.getAvailableBooks()
}