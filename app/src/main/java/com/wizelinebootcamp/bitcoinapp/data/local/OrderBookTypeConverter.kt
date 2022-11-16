package com.wizelinebootcamp.bitcoinapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wizelinebootcamp.bitcoinapp.data.models.BidAskModel

class OrderBookTypeConverter {

    @TypeConverter
    fun bidsToString(bids: List<BidAskModel>): String {
        val gson = Gson()
        return gson.toJson(bids)
    }

    @TypeConverter
    fun bidsToJson(bids: String): List<BidAskModel > {
        val bidsList = object : TypeToken<List<BidAskModel>>() {}.type
        val gson = Gson()
        return gson.fromJson(bids, bidsList)
    }
}
