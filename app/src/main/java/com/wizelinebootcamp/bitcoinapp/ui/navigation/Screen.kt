package com.wizelinebootcamp.bitcoinapp.ui.navigation

sealed class Screen(val route: String) {
    object CoinsList : Screen("coins_list_screen")
    object CoinDetail : Screen("coin_detail_screen?book={book}")
}
