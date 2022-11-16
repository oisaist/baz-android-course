package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class StructureModel(
    @SerializedName("volume") val volume: String? = null,
    @SerializedName("maker") val maker: String? = null,
    @SerializedName("taker") val taker: String? = null
)
