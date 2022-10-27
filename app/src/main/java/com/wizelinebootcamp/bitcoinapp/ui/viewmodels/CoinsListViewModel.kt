package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.data.models.OrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import com.wizelinebootcamp.bitcoinapp.domain.GetAvailableBooksUseCase
import com.wizelinebootcamp.bitcoinapp.domain.GetOrderBookUseCase
import com.wizelinebootcamp.bitcoinapp.domain.GetTickerUseCase
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(
    private val availableBooksUseCase: GetAvailableBooksUseCase
) : ViewModel() {

    private val _availableBooks =
        MutableLiveData<NetworkResponse<BitsoApiResponse>>(NetworkResponse.Loading())
    val availableBooks: LiveData<NetworkResponse<BitsoApiResponse>> = _availableBooks

    private fun getAvailableBooks() = viewModelScope.launch {
        _availableBooks.value = NetworkResponse.Loading()
        Log.d("CryptoApp", "Loading: ${_availableBooks.value}")
        availableBooksUseCase.invoke()
            .catch { e ->
                _availableBooks.value = NetworkResponse.Error(message = e.localizedMessage ?: "An error unexpected occurred")
                Log.d("CryptoApp", "Error: ${(_availableBooks.value as NetworkResponse.Error<BitsoApiResponse>).message}")
            }
            .collect { response ->
                _availableBooks.value = NetworkResponse.Success(response)
                Log.d("CryptoApp", "Success: ${_availableBooks.value}")
            }
    }

    init {
        getAvailableBooks()
    }

}