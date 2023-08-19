package com.example.cashcoin.features

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cashcoin.apiManager.ApiManager
import com.example.cashcoin.apiManager.HOUR
import com.example.cashcoin.apiManager.HOUR24
import com.example.cashcoin.apiManager.model.ChartData
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.databinding.ActivityCoinBinding

class CoinActivity : AppCompatActivity() {
    //create binding:
    lateinit var binding: ActivityCoinBinding

    //create dataCoin variable:
    private lateinit var dataThisCoin: CoinsData.Data

    //api manager
    val apiManager = ApiManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataThisCoin = intent.getParcelableExtra<CoinsData.Data>("dataToSend")!!

        //set title on toolbar
        binding.layoutToolbar.toolbar.title = dataThisCoin.coinInfo.fullName


        //call initUI function for initial user interface:
        initUI()
    }

    private fun initUI() {
        initChartUi()
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
        //call getChartData function:
        apiManager.getChartData(
            "BTC",
            HOUR,
            object : ApiManager.ApiCallBack<Pair<List<ChartData.Data>, ChartData.Data?>> {
                override fun onSuccess(data: Pair<List<ChartData.Data>, ChartData.Data?>) {
                    Log.v("testChart", data.first.toString())
                }

                override fun onError(errorMessage: String) {
                    Toast.makeText(
                        this@CoinActivity,
                        "ERROR -> $errorMessage",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }
}