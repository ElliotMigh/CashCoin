package com.example.cashcoin.features

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashcoin.apiManager.ApiManager
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.databinding.ActivityMarketBinding
import com.example.cashcoin.features.marketActivity.MarketAdapter

class MarketActivity : AppCompatActivity(), MarketAdapter.RecyclerCallBack {
    ///create binding:
    lateinit var binding: ActivityMarketBinding

    //create object api manager
    val apiManager = ApiManager()

    //create data news
    lateinit var dataNews: ArrayList<Pair<String, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //set title on toolbar:
        binding.layoutToolbar.toolbar.title = "CashCoin$ Market"

        //call welcome toast function:
        welcomeToast()

        //call init ui function:
        initUI()

        //click on btn MORE:
        binding.layoutWatchlist.btnShowMore.setOnClickListener {
            val intentShowMoreCoins =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.livecoinwatch.com"))
            startActivity(intentShowMoreCoins)
        }

        //click on swiper refresh:
        binding.swipeRefreshMain.setOnRefreshListener {
            initUI()

            //delayed when not refresh:
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeRefreshMain.isRefreshing = false
            }, 1500)
        }
    }

    private fun welcomeToast() {
        Toast.makeText(this, "Welcome to Cash Coin:)", Toast.LENGTH_SHORT).show()
    }

    private fun initUI() {
        getTopNewsFromApi()
        getTopCoinsFromApi()
    }

    //for news data:
    private fun getTopNewsFromApi() {
        apiManager.getNews(object : ApiManager.ApiCallBack<ArrayList<Pair<String, String>>> {
            override fun onSuccess(data: ArrayList<Pair<String, String>>) {
                dataNews = data
                refreshNews()
            }

            override fun onError(errorMessage: String) {
                Toast.makeText(
                    this@MarketActivity, "ERROR -> $errorMessage", Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    private fun refreshNews() {
        val randomAccess = (0..49).random()

        binding.layoutNews.txtNews.text = dataNews[randomAccess].first //first=title

        //click on img news:
        binding.layoutNews.imgNews.setOnClickListener {
            val intentGoToNews =
                Intent(Intent.ACTION_VIEW, Uri.parse(dataNews[randomAccess].second)) //second=url
            startActivity(intentGoToNews)
        }

        //click on txt news
        binding.layoutNews.txtNews.setOnClickListener {
            refreshNews()
        }
    }

    //for coins list data:
    private fun getTopCoinsFromApi() {
        apiManager.getCoinsList(object : ApiManager.ApiCallBack<List<CoinsData.Data>> {
            override fun onSuccess(data: List<CoinsData.Data>) {
                showDataInRecycler(data)
            }

            override fun onError(errorMessage: String) {
                Toast.makeText(this@MarketActivity, "ERROR -> $errorMessage", Toast.LENGTH_SHORT)
                    .show()
                Log.v("testERROR", errorMessage)
            }

        })
    }

    private fun showDataInRecycler(data: List<CoinsData.Data>) {
        val marketAdapter = MarketAdapter(ArrayList(data), this)
        //set adapter on recyclerView:
        binding.layoutWatchlist.recyclerViewMain.adapter = marketAdapter
        //set layout manager on recyclerView:
        binding.layoutWatchlist.recyclerViewMain.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onCoinItemClicked(dataCoin: CoinsData.Data) {
        //set intent for going to coinActivity:
        val intentGoToCoinActivity = Intent(this, CoinActivity::class.java)
        //send data to coin activity with put extra:
        intentGoToCoinActivity.putExtra("dataToSend", dataCoin)
        startActivity(intentGoToCoinActivity)
    }
}