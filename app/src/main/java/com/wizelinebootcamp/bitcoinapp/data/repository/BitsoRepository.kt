package com.wizelinebootcamp.bitcoinapp.data.repository

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import retrofit2.Response

interface BitsoRepository {

    suspend fun getAvailableBooks(): BitsoApiResponse
}