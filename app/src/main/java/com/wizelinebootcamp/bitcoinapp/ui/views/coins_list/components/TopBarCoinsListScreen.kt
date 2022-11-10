package com.wizelinebootcamp.bitcoinapp.ui.views.coins_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wizelinebootcamp.bitcoinapp.R
import java.time.format.TextStyle

@Composable
fun TopBarCoinsListScreen() {
    TopAppBar(
        title = { Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.top_bar_coins_list_screen),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        ) },
        elevation = 4.dp,
    )
}