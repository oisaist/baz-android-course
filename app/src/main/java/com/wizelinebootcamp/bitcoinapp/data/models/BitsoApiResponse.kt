package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class BitsoApiResponse(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("payload") val payload: List<PayloadModel> = listOf()
)
