package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class OrderBookModel(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("payload") val payload: PayloadOrderBookModel = PayloadOrderBookModel()
)

data class PayloadOrderBookModel(
    @SerializedName("updated_at") val updated_at: String = "",
    @SerializedName("sequence") val sequence: String = "",
    @SerializedName("bids") val bids: List<BidAskModel> = listOf(),
    @SerializedName("asks") val asks: List<BidAskModel> = listOf()
)

data class BidAskModel(
    @SerializedName("book") val book: String = "",
    @SerializedName("price") val price: String = "",
    @SerializedName("amount") val amount: String = ""
)
