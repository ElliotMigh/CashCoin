package com.example.cashcoin.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cashcoin.databinding.ActivityCoinBinding

class CoinActivity : AppCompatActivity() {
    //create binding:
    lateinit var binding: ActivityCoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //call initUI function for initial user interface:
        initUI()
    }

    private fun initUI() {
        initChartUi()
        initStatisticsUi()
        initAboutUi()
    }

    private fun initStatisticsUi() {
        TODO("Not yet implemented")
    }

    private fun initAboutUi() {
        TODO("Not yet implemented")
    }

    private fun initChartUi() {
        TODO("Not yet implemented")
    }
}