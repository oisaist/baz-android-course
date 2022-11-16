package com.wizelinebootcamp.bitcoinapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadOrderBookModel
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadTickerModel
import com.wizelinebootcamp.bitcoinapp.domain.GetOrderBookUseCase
import com.wizelinebootcamp.bitcoinapp.domain.GetTickerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val tickerUseCase: GetTickerUseCase,
    private val orderBookUseCase: GetOrderBookUseCase
) : ViewModel() {

    private val _ticker = MutableLiveData<PayloadTickerModel>()
    val ticker: LiveData<PayloadTickerModel> = _ticker

    private val _orderBook = MutableLiveData<PayloadOrderBookModel>()
    val orderBook: LiveData<PayloadOrderBookModel> = _orderBook

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    suspend fun getTicker(book: String) {
        compositeDisposable?.add(
            tickerUseCase.invoke(book)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { Log.d("CryptoApp", "doOnNext from CoinDetailViewModel") }
                .subscribe(
                    { ticker ->
                        _ticker.postValue(ticker)
                        Log.d("CryptoApp", "doOnSuccess from CoinDetailViewModel")
                    },
                    { t ->
                        Log.d(
                            "CryptoApp",
                            t.localizedMessage ?: "doOnError from CoinDetailViewModel"
                        )
                    }
                )
        )
    }

    fun getOrderBook(book: String) = viewModelScope.launch(Dispatchers.IO) {
        _orderBook.postValue(orderBookUseCase.invoke(book))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.dispose()
    }
}
