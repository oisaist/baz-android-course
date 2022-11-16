package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizelinebootcamp.bitcoinapp.core.ext_functions.formatAsCurrency
import com.wizelinebootcamp.bitcoinapp.data.models.BidAskModel

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
                            style = MaterialTheme.typography.body1,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(
                    text = model.book ?: "",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                model.price?.toFloat()?.let {
                    Text(
                        text = it.formatAsCurrency(),
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                model.amount?.toFloat()?.let {
                    Text(
                        text = it.formatAsCurrency(),
                        style = MaterialTheme.typography.body1
                    )
                }
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
