package com.example.mercadolibresearch.utils

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.round

fun getPercentageOff(price: Double, originalPrice: Double): Int {
    return round(((originalPrice - price) / originalPrice) * 100.0).toInt()
}

fun getPriceFormatted(price: Double): String {
    val formatter: DecimalFormat = NumberFormat.getInstance(Locale.US) as DecimalFormat
    formatter.applyPattern("#,###")
    return formatter.format(price).toString()
}
