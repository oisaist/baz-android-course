package com.wizelinebootcamp.bitcoinapp.domain

import com.wizelinebootcamp.bitcoinapp.data.models.AverageChangeModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Observable
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetTickerUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: BitsoRepository

    private lateinit var getTickerUseCase: GetTickerUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getTickerUseCase = GetTickerUseCase(repository)
    }

    @Test
    fun `repository return a value not empty for ticker`() = runBlocking {
        // Given
        val book = "btc_mxn"
        val ticker = PayloadTickerModel(
            high = "362480",
            last = "318530",
            created_at = "2022-11-10T01:18:24+00:00",
            book = "btc_mxn",
            volume = "367.84769658",
            vwap = "331418.0302165174",
            low = "306280",
            ask = "318510",
            bid = "318080",
            change_24 = "-41770",
            rolling_average_change = AverageChangeModel(s6 = "-0.2903")
        )
        val observable = Observable.just(ticker)
        coEvery { repository.getTicker(book) } returns observable

        // When
        getTickerUseCase(book)

        // Then
        coVerify(exactly = 1) { repository.getTicker(book) }
    }

    @Test
    fun `repository return a value empty for ticker`() = runBlocking {
        val book = "btc_mxn"
        val ticker = PayloadTickerModel(
            high = "",
            last = "",
            created_at = "",
            book = "",
            volume = "",
            vwap = "",
            low = "",
            ask = "",
            bid = "",
            change_24 = "",
            rolling_average_change = AverageChangeModel(s6 = "")
        )
        val observable = Observable.just(ticker)
        coEvery { repository.getTicker(any()) } returns observable

        // When
        getTickerUseCase(book)

        // Then
        coVerify(exactly = 1) { repository.getTicker(any()) }
    }
}
