package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class FlatRateModel(
    @SerializedName("maker") val maker: String? = null,
    @SerializedName("taker") val taker: String? = null
)
