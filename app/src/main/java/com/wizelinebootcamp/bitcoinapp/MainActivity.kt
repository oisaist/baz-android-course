package com.wizelinebootcamp.bitcoinapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wizelinebootcamp.bitcoinapp.ui.theme.BitCoinAppTheme
import com.wizelinebootcamp.bitcoinapp.ui.viewmodels.BitsoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val bitsoViewModel: BitsoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bitsoViewModel.getAvailableBooks()
        setContent {
            BitCoinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val availableBooks = bitsoViewModel.availableBooks.observeAsState().value
                    val loading = bitsoViewModel.loading.observeAsState().value
                    val errorMessage = bitsoViewModel.errorMessage.observeAsState().value
                    Log.d("BitsoApp", "availableBooks: $availableBooks")
                    Log.e("BitsoApp", "loading: $loading")
                    Log.d("BitsoApp", "errorMessage: $errorMessage")
                    Greeting("${availableBooks?.payload}")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BitCoinAppTheme {
        Greeting("Android")
    }
}