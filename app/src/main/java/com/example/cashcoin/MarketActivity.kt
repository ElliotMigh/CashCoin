package com.example.cashcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cashcoin.databinding.ActivityMainBinding

class MarketActivity : AppCompatActivity() {
    //create binding:
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //call welcome toast function:
        welcomeToast()
    }
    private fun welcomeToast(){
        Toast.makeText(this, "Welcome to Cash Coin:)", Toast.LENGTH_SHORT).show()
    }
}