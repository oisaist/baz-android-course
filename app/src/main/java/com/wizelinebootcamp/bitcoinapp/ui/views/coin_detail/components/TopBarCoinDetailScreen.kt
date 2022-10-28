package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wizelinebootcamp.bitcoinapp.R
import com.wizelinebootcamp.bitcoinapp.ui.navigation.Screen

@Composable
fun TopBarCoinDetailScreen(
    navController: NavController
) {
    TopAppBar(
        title = { Text(
            text = stringResource(R.string.top_bar_detail_screen),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        ) },
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }
    )
}