package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizelinebootcamp.bitcoinapp.data.models.TickerModel
import com.wizelinebootcamp.bitcoinapp.utils.ext_functions.formatAsCurrency

@Composable
fun TickerInformation(
    title: String = "",
    value: String = ""
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = if (value.isNotEmpty()) value.toFloat().formatAsCurrency() else "-",
            style = MaterialTheme.typography.subtitle1,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
    }
    Column {
        Divider(color = Color(0xFFc7c7c7), thickness = 0.5.dp)
    }
}

@Preview
@Composable
fun TickerInformationPreview() {
    TickerInformation(
        title = "Last Price",
        value = "$ 135,000.00"
    )
}