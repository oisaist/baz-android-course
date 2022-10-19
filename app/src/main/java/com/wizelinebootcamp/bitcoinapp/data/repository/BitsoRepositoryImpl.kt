package com.wizelinebootcamp.bitcoinapp.data.repository

import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.remote.RemoteBitsoDataSource
import retrofit2.Response
import javax.inject.Inject

class BitsoRepositoryImpl @Inject constructor(
    private val remoteBitsoDataSource: RemoteBitsoDataSource
): BitsoRepository {

    override suspend fun getAvailableBooks(): BitsoApiResponse = remoteBitsoDataSource.getAvailableBooks()
}