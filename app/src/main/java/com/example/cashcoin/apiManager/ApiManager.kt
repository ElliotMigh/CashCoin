package com.example.cashcoin.apiManager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://min-api.cryptocompare.com/data/"
const val BASE_URL_IMAGE = "https://www.cryptocompare.com"
const val API_KEY = "79a0afc8e1acf0c14d61b201c82c5d491e7a8a6be83b94279a4b72b904ba80a9"
const val APP_NAME = "CashCoin"

class ApiManager {

    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    interface ApiCallBack<T> {
        fun onSuccess(data: T)
        fun onError(errorMessage: String)
    }
}