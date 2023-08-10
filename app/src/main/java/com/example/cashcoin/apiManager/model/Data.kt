package com.example.cashcoin.apiManager.model

data class Data(
    val body: String,
    val categories: String,
    val downvotes: String,
    val guid: String,
    val id: String,
    val imageurl: String,
    val lang: String,
    val published_on: Int,
    val source: String,
    val source_info: SourceInfo,
    val tags: String,
    val title: String,
    val upvotes: String,
    val url: String
)