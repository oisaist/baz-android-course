package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizelinebootcamp.bitcoinapp.data.models.BidAskModel
import com.wizelinebootcamp.bitcoinapp.ui.theme.CustomGreen
import com.wizelinebootcamp.bitcoinapp.utils.ext_functions.formatAsCurrency

@Composable
fun BidAskItem(
    model: BidAskModel
) {
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        val titleList = listOf("Book: ", "Price: ", "Amount: ")
        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                titleList.forEach {
                    Row {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.subtitle1,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(
                    text = model.book,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = model.price.toFloat().formatAsCurrency(),
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                Text(
                    text = model.amount.toFloat().formatAsCurrency(),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BidAskItemPreview() {
    BidAskItem(
        model = BidAskModel(
            book = "btc_mxn",
            price = "$12,345.00",
            amount = "$0.1234"
        )
    )
}