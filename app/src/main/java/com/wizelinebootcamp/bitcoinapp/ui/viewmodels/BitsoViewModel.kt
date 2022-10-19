package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizelinebootcamp.bitcoinapp.data.models.BitsoApiResponse
import com.wizelinebootcamp.bitcoinapp.domain.GetAvailableBooksUseCase
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BitsoViewModel @Inject constructor(
    private val availableBooksUseCase: GetAvailableBooksUseCase
): ViewModel() {

    private val _availableBooks = MutableLiveData<BitsoApiResponse?>()
    val availableBooks: LiveData<BitsoApiResponse?> = _availableBooks

    val loading = MutableLiveData<Boolean>(false)
    val errorMessage = MutableLiveData<String?>()

    fun getAvailableBooks() = viewModelScope.launch {
        try {
            availableBooksUseCase.invoke()
                .collect {
                    when(it) {
                        is NetworkResponse.Loading -> {
                            loading.value = true
                        }
                        is NetworkResponse.Success -> {
                            loading.value = false
                            _availableBooks.value = it.data
                        }
                        else -> {
                            loading.value = false
                            errorMessage.value = it.message
                        }
                    }
            }
        } catch (e: Exception) { }
    }

}