package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.wizelinebootcamp.bitcoinapp.R
import com.wizelinebootcamp.bitcoinapp.ui.theme.CustomGreen

@Composable
fun CoinImage(coinName: String) {
    Box(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://cryptoflash-icons-api.herokuapp.com/128/$coinName")
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_cloud_download),
            error = painterResource(id = R.drawable.ic_image_not_supported),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(1.5.dp, CustomGreen, CircleShape)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CoinImagePreview() {
    CoinImage(coinName = "btc_mxn")
}
