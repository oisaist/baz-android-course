package com.wizelinebootcamp.bitcoinapp.data.models

import com.google.gson.annotations.SerializedName

data class FeesModel(
    @SerializedName("flat_rate") val flat_rate: FlatRateModel? = FlatRateModel(),
    @SerializedName("structure") val structure: List<StructureModel>? = listOf()
)
