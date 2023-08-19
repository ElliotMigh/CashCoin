package com.example.cashcoin.features.coinActivity

import com.example.cashcoin.apiManager.model.ChartData
import com.robinhood.spark.SparkAdapter

class ChartAdapter(
    private val historyCallData: List<ChartData.Data>,
    private val baseLine: String?
) : SparkAdapter() {
    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(index: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getY(index: Int): Float {
        TODO("Not yet implemented")
    }
}