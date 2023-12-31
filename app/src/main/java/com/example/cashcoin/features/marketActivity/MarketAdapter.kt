package com.example.cashcoin.features.marketActivity

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cashcoin.apiManager.BASE_URL
import com.example.cashcoin.apiManager.BASE_URL_IMAGE
import com.example.cashcoin.apiManager.model.CoinsData
import com.example.cashcoin.databinding.ItemRecyclerMarketBinding

class MarketAdapter(
    private val data: ArrayList<CoinsData.Data>,
    private val recyclerCallBack: RecyclerCallBack
) :
    RecyclerView.Adapter<MarketAdapter.MarketViewHolder>() {
    //create binding:
    lateinit var binding: ItemRecyclerMarketBinding

    inner class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //create function for set views:
        fun bindViews(dataCoin: CoinsData.Data) {
            binding.txtCoinName.text = dataCoin.coinInfo.fullName
            binding.txtPrice.text = dataCoin.dISPLAY.uSD.pRICE
            binding.txtMarketCap.text = dataCoin.dISPLAY.uSD.mKTCAP

            val taqir = dataCoin.rAW.uSD.cHANGE24HOUR
            if (taqir > 0) {
                binding.txtTaqir.setTextColor(Color.parseColor("#50b12a"))
            } else {
                binding.txtTaqir.setTextColor(Color.parseColor("#f0655e"))
            }
            binding.txtTaqir.text = dataCoin.dISPLAY.uSD.cHANGE24HOUR


            //use Glide library for loading pic from internet using URL:
            Glide.with(itemView)
                .load(BASE_URL_IMAGE + dataCoin.coinInfo.imageUrl)
                .into(binding.imgItem)

            //click on item:
            itemView.setOnClickListener {
                recyclerCallBack.onCoinItemClicked(dataCoin)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemRecyclerMarketBinding.inflate(inflater, parent, false)
        return MarketViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int = data.size

    interface RecyclerCallBack {
        fun onCoinItemClicked(dataCoin: CoinsData.Data)
    }
}