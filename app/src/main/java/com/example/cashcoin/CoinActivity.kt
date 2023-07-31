package com.example.cashcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cashcoin.databinding.ActivityCoinBinding
import com.example.cashcoin.databinding.ActivityMainBinding

class CoinActivity : AppCompatActivity() {
    //create binding:
    lateinit var binding: ActivityCoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}