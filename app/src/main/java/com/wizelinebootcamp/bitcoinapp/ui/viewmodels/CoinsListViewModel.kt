package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizelinebootcamp.bitcoinapp.core.NetworkResponse
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.domain.GetAvailableBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class CoinsListViewModel @Inject constructor(
    private val availableBooksUseCase: GetAvailableBooksUseCase
) : ViewModel() {

    private val _availableBooks =
        MutableLiveData<NetworkResponse<List<PayloadModel>?>>(NetworkResponse.Loading())
    val availableBooks: LiveData<NetworkResponse<List<PayloadModel>?>> = _availableBooks

    private fun getAvailableBooks() = viewModelScope.launch(Dispatchers.IO) {
        try {
            availableBooksUseCase.invoke()
                .collect {
                    when (it) {
                        is NetworkResponse.Loading -> {
                            _availableBooks.postValue(NetworkResponse.Loading())
                        }
                        is NetworkResponse.Success -> {
                            _availableBooks.postValue(NetworkResponse.Success(it.data))
                        }
                        is NetworkResponse.Error -> {
                            _availableBooks.postValue(NetworkResponse.Error(it.message))
                        }
                    }
                }
        } catch (ex: Exception) {
            Log.d("CryptoApp", "Loading: ${ex.localizedMessage}")
        }
    }

    fun getCoinIcon(coinName: String): String =
        "https://cryptoflash-icons-api.herokuapp.com/128/$coinName"

    init {
        getAvailableBooks()
    }
}
