package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.domain.GetAvailableBooksUseCase
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

    private fun getAvailableBooks() = viewModelScope.launch(Dispatchers.IO) {
        _availableBooks.postValue(NetworkResponse.Loading())
        Log.d("CryptoApp", "Loading: ${_availableBooks.value}")
        availableBooksUseCase.invoke()
            .catch { e ->
                _availableBooks.postValue(NetworkResponse.Error(message = e.localizedMessage ?: "An error unexpected occurred"))
                Log.d("CryptoApp", "Error: ${(_availableBooks.value as NetworkResponse.Error<BitsoApiResponse>).message}")
            }
            .collect { response ->
                _availableBooks.postValue(NetworkResponse.Success(response))
                Log.d("CryptoApp", "Success: ${_availableBooks.value}")
            }
    }

    fun getCoinIcon(coinName: String): String = "https://cryptoflash-icons-api.herokuapp.com/128/${coinName}"

    init {
        getAvailableBooks()
    }

}