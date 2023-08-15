package com.example.cashcoin.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cashcoin.databinding.ActivityMarketBinding

class MarketActivity : AppCompatActivity() {
    ///create binding:
    lateinit var binding: ActivityMarketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //call welcome toast function:
        welcomeToast()

        //call init ui function:
        initUI()
    }

    private fun welcomeToast() {
        Toast.makeText(this, "Welcome to Cash Coin:)", Toast.LENGTH_SHORT).show()
    }

    private fun initUI() {

    }
}