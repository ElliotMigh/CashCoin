package com.example.cashcoin.features

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.cashcoin.R
import com.example.cashcoin.apiManager.*
import com.example.cashcoin.apiManager.model.ChartData
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.databinding.ActivityCoinBinding
import com.example.cashcoin.features.coinActivity.ChartAdapter

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

    @SuppressLint("SetTextI18n")
    private fun initChartUi() {

        var period: String = HOUR
        //for first show data:
        requestAndShowData(period)

        //click on radioGroup:
        binding.layoutChart.radioGroup.setOnCheckedChangeListener { _, checkId ->
            when (checkId) {
                R.id.radio12h -> {
                    period = HOUR
                }
                R.id.radio1d -> {
                    period = HOUR24
                }
                R.id.radio1w -> {
                    period = WEEK
                }
                R.id.radio1m -> {
                    period = MONTH
                }
                R.id.radio3m -> {
                    period = MONTH3
                }
                R.id.radio1y -> {
                    period = YEAR
                }
                R.id.radioAll -> {
                    period = ALL
                }
            }
            requestAndShowData(period)
        }

        //change txt price:
        binding.layoutChart.txtPrice.text = dataThisCoin.dISPLAY.uSD.pRICE

        //change txt chartChange2:
        binding.layoutChart.txtChartChange2.text =
            dataThisCoin.rAW.uSD.cHANGEPCT24HOUR.toString().substring(0, 5) + "%"
        binding.layoutChart.txtChartChange1.text = dataThisCoin.dISPLAY.uSD.cHANGE24HOUR

        val taqir = dataThisCoin.rAW.uSD.cHANGE24HOUR
        if (taqir > 0) {

            binding.layoutChart.txtChartChange2.setTextColor(Color.parseColor("#50b12a"))
            binding.layoutChart.txtChartUpDown.setTextColor(Color.parseColor("#50b12a"))
            binding.layoutChart.txtChartUpDown.text = "▲"

            //change spark color:
            binding.layoutChart.sparkView.lineColor = ContextCompat.getColor(
                binding.root.context,
                R.color.colorGain
            )

        } else if (taqir < 0) {

            binding.layoutChart.txtChartChange2.setTextColor(Color.parseColor("#f0655e"))
            binding.layoutChart.txtChartUpDown.setTextColor(Color.parseColor("#f0655e"))
            binding.layoutChart.txtChartUpDown.text = "▼"

            //change spark color:
            binding.layoutChart.sparkView.lineColor = ContextCompat.getColor(
                binding.root.context,
                R.color.colorLoss
            )

        }

        //set scrub listener on sparkView:
        binding.layoutChart.sparkView.setScrubListener {
            //show full price:
            if (it == null) {
                binding.layoutChart.txtPrice.text = dataThisCoin.dISPLAY.uSD.pRICE
            } else {
                //show price this dot . :
                binding.layoutChart.txtPrice.text = "$" + (it as ChartData.Data).close.toString()
            }
        }
    }

    private fun requestAndShowData(period: String) {
        //call getChartData function:
        apiManager.getChartData(
            dataThisCoin.coinInfo.name,
            period,
            object : ApiManager.ApiCallBack<Pair<List<ChartData.Data>, ChartData.Data?>> {
                override fun onSuccess(data: Pair<List<ChartData.Data>, ChartData.Data?>) {

                    val chartAdapter = ChartAdapter(data.first, data.second?.open.toString())
                    binding.layoutChart.sparkView.adapter = chartAdapter
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