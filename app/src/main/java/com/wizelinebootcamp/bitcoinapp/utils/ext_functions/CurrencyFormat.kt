package com.wizelinebootcamp.bitcoinapp.utils.ext_functions

import java.text.NumberFormat

fun Float.formatAsCurrency(): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.maximumFractionDigits = 7
    return numberFormat.format(this)
}
