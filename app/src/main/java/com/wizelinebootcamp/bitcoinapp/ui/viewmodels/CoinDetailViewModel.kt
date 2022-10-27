package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import com.wizelinebootcamp.bitcoinapp.domain.GetOrderBookUseCase
import com.wizelinebootcamp.bitcoinapp.domain.GetTickerUseCase
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val tickerUseCase: GetTickerUseCase,
    private val orderBookUseCase: GetOrderBookUseCase
): ViewModel() {

    private val _ticker = MutableLiveData<TickerModel?>()
    val ticker: LiveData<TickerModel?> = _ticker

    private val _orderBook = MutableLiveData<NetworkResponse<OrderBookModel>>()
    val orderBook: LiveData<NetworkResponse<OrderBookModel>> = _orderBook

    fun getTicker(book: String) = viewModelScope.launch(Dispatchers.IO) {
        tickerUseCase.invoke(book)
            .catch {

            }
            .collect {
                _ticker.postValue(it)
                /*when (it) {
                    is NetworkResponse.Loading -> {
                    }
                    is NetworkResponse.Success -> {
                        _ticker.value = it.data
                    }
                    is NetworkResponse.Error -> {
                    }
                }*/
        }
        /*_ticker.postValue(NetworkResponse.Loading())
        tickerUseCase.invoke(book)
            .catch { e ->
                _ticker.postValue(NetworkResponse.Error(message = e.localizedMessage ?: "An error unexpected occurred"))
            }
            .collect { response ->
                _ticker.postValue(NetworkResponse.Success(response))
            }*/
    }

    fun getOrderBook(book: String) = viewModelScope.launch {
        _orderBook.value = NetworkResponse.Loading()
        Log.d("CryptoApp", "Loading: ${_orderBook.value}")
        orderBookUseCase.invoke(book)
            .catch { e ->
                _orderBook.value = NetworkResponse.Error(e.localizedMessage ?: "An error unexpected occurred")
                Log.d("CryptoApp", "Error: ${_orderBook.value}")
            }
            .collect { response ->
                _orderBook.value = NetworkResponse.Success(response)
                Log.d("CryptoApp", "Success: ${_orderBook.value}")

            }
    }
}