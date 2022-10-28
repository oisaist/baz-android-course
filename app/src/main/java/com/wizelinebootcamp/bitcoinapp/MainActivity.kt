package com.wizelinebootcamp.bitcoinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wizelinebootcamp.bitcoinapp.ui.navigation.NavigationGraph
import com.wizelinebootcamp.bitcoinapp.ui.theme.BitCoinAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BitCoinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /*val books = coinListViewModel.availableBooks.observeAsState().value
                    //val listBooks = books?.payload?.map { it.book }?.distinct()
                    val listBooks = books?.payload?.filter { it.book!!.contains("mxn") }
                    listBooks?.forEach {
                        val coinName = it.book?.split("_")
                        Log.d("CryptoApp", "${coinName?.get(0)}")
                    }
                    Log.e("CryptoApp", "Size: listBooks: ${listBooks?.size}")*/
                    val navController = rememberNavController()
                    NavigationGraph(
                        navController = navController
                    )
                }
            }
        }
    }
}