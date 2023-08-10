package com.example.cashcoin.apiManager.model

data class NewsData(
    val Data: List<Data>,
    val HasWarning: Boolean,
    val Message: String,
    val Promoted: List<Any>,
    val RateLimit: RateLimit,
    val Type: Int
)