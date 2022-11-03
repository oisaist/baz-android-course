package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class TickerModel(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("payload") val payload: PayloadTickerModel? = null
)

data class PayloadTickerModel(
    @SerializedName("high") val high: String? = "",
    @SerializedName("last") val last: String? = "",
    @SerializedName("created_at") val created_at: String? = "",
    @SerializedName("book") val book: String? = "",
    @SerializedName("volume") val volume: String? = "",
    @SerializedName("vwap") val vwap: String? = "",
    @SerializedName("low") val low: String? = "",
    @SerializedName("ask") val ask: String? = "",
    @SerializedName("bid") val bid: String? = "",
    @SerializedName("change_24") val change_24: String? = "",
    @SerializedName("rolling_average_change") val rolling_average_change: AverageChangeModel? = AverageChangeModel(),
)

data class AverageChangeModel(
    @SerializedName("6") val s6: String = ""
)
