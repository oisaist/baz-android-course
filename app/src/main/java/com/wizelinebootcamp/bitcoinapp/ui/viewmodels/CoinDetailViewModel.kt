package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizelinebootcamp.bitcoinapp.domain.GetOrderBookUseCase
import com.wizelinebootcamp.bitcoinapp.domain.GetTickerUseCase
import com.wizelinebootcamp.bitcoinapp.core.NetworkResponse
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadOrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val tickerUseCase: GetTickerUseCase,
    private val orderBookUseCase: GetOrderBookUseCase
) : ViewModel() {

    private val _ticker = MutableLiveData<PayloadTickerModel>()
    val ticker: LiveData<PayloadTickerModel> = _ticker

    private val _orderBook = MutableLiveData<PayloadOrderBookModel>()
    val orderBook: LiveData<PayloadOrderBookModel> = _orderBook

    fun getTicker(book: String) = viewModelScope.launch(Dispatchers.IO) {
        _ticker.postValue(tickerUseCase.invoke(book))
    }

    fun getOrderBook(book: String) = viewModelScope.launch(Dispatchers.IO) {
        _orderBook.postValue(orderBookUseCase.invoke(book))
    }
}