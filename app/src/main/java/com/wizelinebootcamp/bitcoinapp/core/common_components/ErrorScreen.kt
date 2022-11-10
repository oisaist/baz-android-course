package com.wizelinebootcamp.bitcoinapp.core.common_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ErrorScreen(
    modifier: Modifier,
    errorText: String
) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = errorText,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.body1.fontSize
        )
    }
}