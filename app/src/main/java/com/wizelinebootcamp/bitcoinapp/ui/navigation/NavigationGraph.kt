package com.wizelinebootcamp.bitcoinapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wizelinebootcamp.bitcoinapp.ui.views.CoinsListScreen
import com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.CoinDetailScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.CoinsList.route) {
        composable(Screen.CoinsList.route) {
            CoinsListScreen(navController = navController)
        }
        composable(
            route = Screen.CoinDetail.route,
            arguments = listOf(
                navArgument("book") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            val book = it.arguments?.getString("book").toString()
            CoinDetailScreen(
                navController = navController,
                book = book
            )
        }
    }
}
