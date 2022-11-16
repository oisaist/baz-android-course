package com.wizelinebootcamp.bitcoinapp.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wizelinebootcamp.bitcoinapp.R
import com.wizelinebootcamp.bitcoinapp.core.NetworkResponse
import com.wizelinebootcamp.bitcoinapp.core.common_components.CustomProgressBar
import com.wizelinebootcamp.bitcoinapp.core.common_components.CustomTopAppBar
import com.wizelinebootcamp.bitcoinapp.core.common_components.EmptyContent
import com.wizelinebootcamp.bitcoinapp.core.common_components.ErrorScreen
import com.wizelinebootcamp.bitcoinapp.ui.viewmodels.CoinsListViewModel
import com.wizelinebootcamp.bitcoinapp.ui.views.coins_list.components.CoinsList

@Composable
fun CoinsListScreen(
    navController: NavController,
    coinListViewModel: CoinsListViewModel = hiltViewModel()
) {
    val networkResponse = coinListViewModel.availableBooks.observeAsState().value
    Scaffold(
        topBar = {
            CustomTopAppBar(
                navController = navController,
                title = stringResource(id = R.string.top_bar_coins_list_screen),
            )
        },
        content = {
            when (networkResponse) {
                is NetworkResponse.Loading -> {
                    CustomProgressBar(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                is NetworkResponse.Success -> {
                    if (networkResponse.data.isNullOrEmpty()) {
                        EmptyContent(modifier = Modifier.fillMaxSize())
                    } else {
                        CoinsList(
                            navController = navController,
                            coinsList = networkResponse.data,
                            coinListViewModel = coinListViewModel
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
