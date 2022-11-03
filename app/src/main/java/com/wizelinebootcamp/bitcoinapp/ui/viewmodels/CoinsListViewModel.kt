package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.domain.GetAvailableBooksUseCase
import com.wizelinebootcamp.bitcoinapp.core.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

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
            /*_availableBooks.postValue(NetworkResponse.Loading())
            availableBooksUseCase.invoke()
                .catch { e ->
                    _availableBooks.postValue(
                        NetworkResponse.Error(
                            message = e.localizedMessage ?: "An error unexpected occurred"
                        )
                    )
                }
                .collect { response ->
                    _availableBooks.postValue(NetworkResponse.Success(response))
                }*/
        } catch (ex: Exception) {
            Log.d("CryptoApp", "Loading: ${ex.localizedMessage}")
        }
    }

    fun getCoinIcon(coinName: String): String =
        "https://cryptoflash-icons-api.herokuapp.com/128/${coinName}"

    init {
        getAvailableBooks()
    }

}