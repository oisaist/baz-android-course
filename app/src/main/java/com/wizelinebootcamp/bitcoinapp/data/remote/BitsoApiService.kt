package com.wizelinebootcamp.bitcoinapp.data.remote

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface BitsoApiService {

    @GET("available_books")
    suspend fun getAvailableBooks() : BitsoApiResponse
}