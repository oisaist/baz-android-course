package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wizelinebootcamp.bitcoinapp.ui.theme.LighterGray
import com.wizelinebootcamp.bitcoinapp.ui.viewmodels.CoinDetailViewModel
import com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components.*
import com.wizelinebootcamp.bitcoinapp.core.NetworkResponse
import com.wizelinebootcamp.bitcoinapp.core.common_components.CustomProgressBar
import com.wizelinebootcamp.bitcoinapp.core.common_components.EmptyContent
import com.wizelinebootcamp.bitcoinapp.core.common_components.ErrorScreen

@Composable
fun CoinDetailScreen(
    navController: NavController,
    book: String?,
    coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
) {
    val coinName = book?.split("_")
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = true) {
        coinDetailViewModel.getTicker(book!!)
        coinDetailViewModel.getOrderBook(book)
    }
    val ticker = coinDetailViewModel.ticker.observeAsState()
    val orderBook = coinDetailViewModel.orderBook.observeAsState()

    Scaffold(
        topBar = { TopBarCoinDetailScreen(navController) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                CoinImage(coinName?.get(0) ?: "")
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = LighterGray
                        )
                ) {
                    CustomSpacer()
                    Text(text = "Prices", style = MaterialTheme.typography.h6, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    TickerInformation(title = "High price: ", value = ticker.value?.high ?: "")
                    TickerInformation(title = "Last price: ", value = ticker.value?.last ?: "")
                    TickerInformation(title = "Low price: ", value = ticker.value?.low ?: "")
                }
                CustomSpacer()
                Text(
                    text = "Bids",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                CustomSpacer()
                BidAskList(bidAksModel = orderBook.value?.bids ?: listOf())

                CustomSpacer()
                Text(
                    text = "Asks",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                CustomSpacer()
                BidAskList(
                    bidAksModel = orderBook.value?.asks ?: listOf()
                )
            }
        }
    )
}