package com.wizelinebootcamp.bitcoinapp.ui.views.coin_detail.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.wizelinebootcamp.bitcoinapp.data.models.BidAskModel

@Composable
fun BidAskList(
    bidAksModel: List<BidAskModel>
) {
    LazyRow {
        items(bidAksModel) { model ->
            BidAskItem(model)
        }
    }
}
