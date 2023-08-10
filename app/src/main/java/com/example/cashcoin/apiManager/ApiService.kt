package com.example.cashcoin.apiManager

import com.example.cashcoin.apiManager.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(API_KEY)
    @GET("v2/news")
    fun getTopNews(
        @Query("sortOrder") sortOrder: String = "popular"
    ): Call<NewsData>
}