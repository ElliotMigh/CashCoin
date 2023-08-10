package com.example.cashcoin.apiManager

import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(API_KEY)
    @GET("v2/news")
    fun getTopNews()
}