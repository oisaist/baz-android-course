package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.data.models.BidAskModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadOrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetOrderBookUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: BitsoRepository

    lateinit var getOrderBookUseCase: GetOrderBookUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getOrderBookUseCase = GetOrderBookUseCase(repository)
    }

    @Test
    fun `repository return a value not empty`() = runBlocking {
        // Given
        val book = "btc_mxn"
        val orderBook = PayloadOrderBookModel(
            updated_at = "2022-11-09T21:51:27+00:00",
            sequence = "2187565727",
            bids = listOf(BidAskModel(book = "btc_mxn", price = "311910", amount = "0.21187191")),
            asks = listOf(BidAskModel(book = "btc_mxn", price = "312070", amount = "0.00667443"))
        )
        coEvery { repository.getOrderBook(book) } returns orderBook

        // When
        getOrderBookUseCase(book)

        // Then
        coVerify(exactly = 1) { repository.getOrderBook(book) }
    }

    @Test
    fun `repository return a value empty`() = runBlocking {
        val book = "btc_mxn"
        val orderBook = PayloadOrderBookModel(
            updated_at = "",
            sequence = "",
            bids = listOf(),
            asks = listOf()
        )
        coEvery { repository.getOrderBook(book) } returns orderBook

        // When
        getOrderBookUseCase(book)

        // Then
        coVerify(exactly = 1) { repository.getOrderBook(book) }
    }
}
