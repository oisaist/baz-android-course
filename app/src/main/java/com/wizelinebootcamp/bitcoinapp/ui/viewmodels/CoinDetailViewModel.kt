package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

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
) : ViewModel() {

    private val _ticker = MutableLiveData<TickerModel?>()
    val ticker: LiveData<TickerModel?> = _ticker

    private val _orderBook = MutableLiveData<NetworkResponse<OrderBookModel>>()
    val orderBook: LiveData<NetworkResponse<OrderBookModel>> = _orderBook

    fun getTicker(book: String) = viewModelScope.launch(Dispatchers.IO) {
        tickerUseCase.invoke(book)
            .catch {  }
            .collect {
                _ticker.postValue(it)
        }
    }

    fun getOrderBook(book: String) = viewModelScope.launch(Dispatchers.IO) {
        _orderBook.postValue(NetworkResponse.Loading())
        orderBookUseCase.invoke(book)
            .catch { e ->
                _orderBook.postValue(NetworkResponse.Error(e.localizedMessage ?: "An error unexpected occurred"))
            }
            .collect { response ->
                _orderBook.postValue(NetworkResponse.Success(response))

            }
    }
}