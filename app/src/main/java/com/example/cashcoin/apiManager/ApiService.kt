package com.example.cashcoin.apiManager

import retrofit2.http.Headers

interface ApiService {

    @Headers(API_KEY)
    fun getTopNews()
}