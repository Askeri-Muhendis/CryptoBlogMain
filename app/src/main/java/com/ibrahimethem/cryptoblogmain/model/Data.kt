package com.ibrahimethem.cryptoblogmain.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("circulating_supply")
    val circulating_supply: Double?,
    @SerializedName("cmc_rank")
    val cmc_rank: Int?,
    @SerializedName("date_added")
    val date_added: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("last_updated")
    val last_updated: String?,
    @SerializedName("max_supply")
    val max_supply: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("num_market_pairs")
    val num_market_pairs: Int?,
    @SerializedName("platform")
    val platform: Platform?,
    @SerializedName("quote")
    val quote: Quote?,
    @SerializedName("self_reported_circulating_supply")
    val self_reported_circulating_supply: Int?,
    @SerializedName("self_reported_market_cap")
    val self_reported_market_cap: Double?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("total_supply")
    val total_supply: Double?,
    @SerializedName("tvl_ratio")
    val tvl_ratio: Any?
)