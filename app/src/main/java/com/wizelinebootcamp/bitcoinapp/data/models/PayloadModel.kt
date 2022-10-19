package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class PayloadModel(
    @SerializedName("book") val book: String? = "",
    @SerializedName("minimum_price") val minimum_price: String? = "",
    @SerializedName("maximum_price") val maximum_price: String? = "",
    @SerializedName("minimum_amount") val minimum_amount: String? = "",
    @SerializedName("maximum_amount") val maximum_amount: String? ="",
    @SerializedName("minimum_value") val minimum_value: String? ="",
    @SerializedName("maximum_value") val maximum_value: String? ="",
    @SerializedName("tick_size") val tick_size: String? ="",
    @SerializedName("default_chart") val default_chart: String? ="",
    @SerializedName("fees") val fees: FeesModel? = FeesModel(),
)
