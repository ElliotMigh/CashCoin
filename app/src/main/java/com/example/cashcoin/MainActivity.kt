package com.example.cashcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call welcome toast function:
        welcomeToast()
    }
    private fun welcomeToast(){
        Toast.makeText(this, "Welcome to Cash Coin:)", Toast.LENGTH_SHORT).show()
    }
}