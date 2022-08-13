package com.ibrahimethem.cryptoblogmain.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimethem.cryptoblogmain.R
import com.ibrahimethem.cryptoblogmain.databinding.ItemCryptoBinding
import com.ibrahimethem.cryptoblogmain.model.Data
import com.ibrahimethem.cryptoblogmain.util.Consts.IMAGE_URL
import com.ibrahimethem.cryptoblogmain.util.extensions.downloadImage

class CryptoListAdapter(
    private val onItemClicked : (Data) -> Unit
) : ListAdapter<Data,CryptoListAdapter.CryptoViewHolder>(
    object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem == newItem
    }
){
    class CryptoViewHolder(
        private val binding : ItemCryptoBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : Data,holder : CryptoViewHolder){
            binding.apply {
                cryptoPrice.text = holder.itemView.context.getString(R.string.crypto_price_set,data.quote?.uSD?.price.toString())
                cryptoSymbol.text = data.symbol
                cryptoImage.downloadImage("${IMAGE_URL}${data.id.toString()}.png")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(
            ItemCryptoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        getItem(position)?.let{item ->
            holder.bind(item,holder)
        }
    }
}