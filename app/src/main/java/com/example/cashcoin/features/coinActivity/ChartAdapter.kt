package com.example.cashcoin.features.coinActivity

import com.example.cashcoin.apiManager.model.ChartData
import com.robinhood.spark.SparkAdapter

class ChartAdapter(
    private val historyCallData: List<ChartData.Data>,
    private val baseLine: String?
) : SparkAdapter() {
    override fun getCount(): Int {
        return historyCallData.size
    }

    override fun getItem(index: Int): ChartData.Data {
        return historyCallData[index]
    }

    override fun getY(index: Int): Float {
        return historyCallData[index].close.toFloat()
    }

    override fun hasBaseLine(): Boolean {
        return true
    }

    override fun getBaseLine(): Float {
        return baseLine?.toFloat() ?: super.getBaseLine()
    }
}