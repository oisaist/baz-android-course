package com.wizelinebootcamp.bitcoinapp.ui.views.coins_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.ui.viewmodels.CoinsListViewModel

@Composable
fun CoinsList(
    navController: NavController,
    coinsList: List<PayloadModel>,
    coinListViewModel: CoinsListViewModel
) {
    LazyColumn {
        items(coinsList) { coin ->
            CoinListItem(
                coin = coin,
                coinListViewModel = coinListViewModel,
                onItemClick = {
                    navController.navigate("coin_detail_screen?book=${it.book}")
                }
            )
        }
    }
}