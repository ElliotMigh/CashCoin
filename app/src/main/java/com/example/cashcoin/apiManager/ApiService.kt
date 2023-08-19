package com.example.cashcoin.apiManager

import com.example.cashcoin.apiManager.model.ChartData
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.apiManager.model.NewsData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @Headers(API_KEY)
    @GET("v2/news/")
    fun getTopNews(
        @Query("sortOrder") sortOrder: String = "popular"
    ): Call<NewsData>

    @Headers(API_KEY)
    @GET("top/totalvolfull")
    fun getTopCoin(
        @Query("tsym") to_symbol: String = "USD",
        @Query("limit") limit_data: Int = 10
    ): Call<CoinsData>

    @Headers(API_KEY)
    @GET("{period}")
    fun getChartData(
        @Path("period") period: String,
        @Query("fsym") fromSymbol: String,
        @Query("limit") limit_data: Int,
        @Query("aggregate") aggregate: Int,
        @Query("tsym") toSymbol: String = "USD"
    ) : Call<ChartData>
}