package com.wizelinebootcamp.bitcoinapp.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wizelinebootcamp.bitcoinapp.ui.viewmodels.CoinsListViewModel
import com.wizelinebootcamp.bitcoinapp.ui.views.coins_list.components.CoinsList
import com.wizelinebootcamp.bitcoinapp.ui.views.coins_list.components.TopBarCoinsListScreen
import com.wizelinebootcamp.bitcoinapp.utils.NetworkResponse
import com.wizelinebootcamp.bitcoinapp.utils.common_components.CustomProgressBar
import com.wizelinebootcamp.bitcoinapp.utils.common_components.EmptyContent
import com.wizelinebootcamp.bitcoinapp.utils.common_components.ErrorScreen

@Composable
fun CoinsListScreen(
    navController: NavController,
    coinListViewModel: CoinsListViewModel = hiltViewModel()
) {
    val networkResponse = coinListViewModel.availableBooks.observeAsState().value
    Scaffold(
        topBar = { TopBarCoinsListScreen() },
        content = {
            when (networkResponse) {
                is NetworkResponse.Loading -> {
                    CustomProgressBar(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                is NetworkResponse.Success -> {
                    if (networkResponse.data?.payload.isNullOrEmpty()) {
                        EmptyContent(modifier = Modifier.fillMaxSize())
                    } else {
                        CoinsList(
                            navController = navController,
                            coinsList = networkResponse.data?.payload ?: listOf()
                        )
                    }
                }
                else -> {
                    ErrorScreen(
                        modifier = Modifier.fillMaxSize(),
                        errorText = networkResponse?.message.toString()
                    )
                }
            }
        }
    )

}