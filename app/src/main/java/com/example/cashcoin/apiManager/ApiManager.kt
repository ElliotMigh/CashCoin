package com.example.cashcoin.apiManager

import com.example.cashcoin.apiManager.model.ChartData
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.apiManager.model.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getNews(apiCallBack: ApiCallBack<ArrayList<Pair<String, String>>>) {

        apiService.getTopNews().enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                val data = response.body()!!.data

                val dataToSend: ArrayList<Pair<String, String>> = arrayListOf()
                data.forEach {
                    dataToSend.add(Pair(it.title, it.url))
                }
                apiCallBack.onSuccess(dataToSend)
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                apiCallBack.onError(t.message!!)
            }

        })
    }

    fun getCoinsList(apiCallBack: ApiCallBack<List<CoinsData.Data>>) {
        apiService.getTopCoin().enqueue(object : Callback<CoinsData> {
            override fun onResponse(call: Call<CoinsData>, response: Response<CoinsData>) {
                val data = response.body()!!
                apiCallBack.onSuccess(data.data)
            }

            override fun onFailure(call: Call<CoinsData>, t: Throwable) {
                apiCallBack.onError(t.message!!)
            }

        })
    }

    fun getChartData(
        symbol: String,
        period: String,
        apiCallBack: ApiCallBack<ChartData>
    ) {

        var histoPeriod = ""
        var limit = 30
        var aggregate = 1

        when (period) {
            HOUR -> {
                histoPeriod = HISTO_MINUTE
                limit - 60
                aggregate = 12
            }
            HOUR24 -> {
                histoPeriod = HISTO_HOUR
                limit = 24
            }

            MONTH -> {
                histoPeriod = HISTO_DAY
                limit = 30
            }

            MONTH3 -> {
                histoPeriod = HISTO_DAY
                limit = 90
            }

            WEEK -> {
                histoPeriod = HISTO_HOUR
                aggregate = 6
            }

            YEAR -> {
                histoPeriod = HISTO_DAY
                aggregate = 13
            }

            ALL -> {
                histoPeriod = HISTO_DAY
                aggregate = 30
                limit = 2000
            }
        }

        apiService.getChartData(histoPeriod, symbol, limit, aggregate)
            .enqueue(object : Callback<ChartData> {
                override fun onResponse(call: Call<ChartData>, response: Response<ChartData>) {
                    val dataToBack = response.body()!!
                    apiCallBack.onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<ChartData>, t: Throwable) {
                    apiCallBack.onError(t.message!!)
                }

            })
    }

    interface ApiCallBack<T> {
        fun onSuccess(data: T)
        fun onError(errorMessage: String)
    }
}