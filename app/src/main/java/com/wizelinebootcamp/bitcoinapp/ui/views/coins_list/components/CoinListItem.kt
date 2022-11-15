package com.wizelinebootcamp.bitcoinapp.ui.views.coins_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.wizelinebootcamp.bitcoinapp.R
import com.wizelinebootcamp.bitcoinapp.data.models.PayloadModel
import com.wizelinebootcamp.bitcoinapp.ui.theme.CustomGreen
import com.wizelinebootcamp.bitcoinapp.ui.theme.CustomRed
import com.wizelinebootcamp.bitcoinapp.ui.viewmodels.CoinsListViewModel
import com.wizelinebootcamp.bitcoinapp.core.ext_functions.formatAsCurrency

@Composable
fun CoinListItem(
    coin: PayloadModel,
    coinListViewModel: CoinsListViewModel,
    onItemClick: (PayloadModel) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        elevation = 6.dp
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
                .weight(1f)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(coinListViewModel.getCoinIcon(coin.bookName ?: ""))
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.ic_cloud_download),
                    error = painterResource(id = R.drawable.ic_default_bitcoin),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                )
            }
            Column(modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f)
            ) {
                Text(
                    text = coin.book?.uppercase() ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .weight(2f),
                horizontalAlignment = Alignment.End
            )  {
                Text(
                    text = "Min: ${coin.minimum_price?.toFloat()?.formatAsCurrency()}",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body1,
                    color = CustomRed,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Max: " + coin.maximum_price?.toFloat()?.formatAsCurrency(),
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body1,
                    color = CustomGreen,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/*
@Preview
@Composable
fun CoinListItemPreview() {
    CoinListItem(
        coin = PayloadModel(
            book = "btc_mxn",
            minimum_price = "40000",
            maximum_price = "20000000"
        ),
        onItemClick = {}
    )
}*/
