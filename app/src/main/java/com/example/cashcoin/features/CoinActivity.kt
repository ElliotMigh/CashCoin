package com.example.cashcoin.features

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.databinding.ActivityCoinBinding

class CoinActivity : AppCompatActivity() {
    //create binding:
    lateinit var binding: ActivityCoinBinding

    //create dataCoin variable:
    private lateinit var dataThisCoin: CoinsData.Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutToolbar.toolbar.title = "About Coin"

        dataThisCoin = intent.getParcelableExtra<CoinsData.Data>("dataToSend")!!


        //call initUI function for initial user interface:
        initUI()
    }

    private fun initUI() {
//        initChartUi()
        initStatisticsUi()
//        initAboutUi()
    }

    @SuppressLint("SetTextI18n")
    private fun initStatisticsUi() {
        binding.layoutStatistics.txtOpenAmount.text = dataThisCoin.dISPLAY.uSD.oPEN24HOUR
        binding.layoutStatistics.txtTodaysHighAmount.text = dataThisCoin.dISPLAY.uSD.hIGH24HOUR
        binding.layoutStatistics.txtTodaysLowAmount.text = dataThisCoin.dISPLAY.uSD.lOW24HOUR
        binding.layoutStatistics.txtChangeTodaysAmount.text = dataThisCoin.dISPLAY.uSD.cHANGE24HOUR
        binding.layoutStatistics.txtAlgorithmAmount.text = dataThisCoin.coinInfo.algorithm
        binding.layoutStatistics.txtTotalVolumeAmount.text = dataThisCoin.dISPLAY.uSD.tOTALVOLUME24H
        binding.layoutStatistics.txtMarketCapAmount.text = dataThisCoin.dISPLAY.uSD.mKTCAP
        binding.layoutStatistics.txtSupplyAmount.text = dataThisCoin.dISPLAY.uSD.sUPPLY
    }

    private fun initAboutUi() {
        Log.v("test", "test")
    }

    private fun initChartUi() {
        Log.v("test", "test")
    }
}