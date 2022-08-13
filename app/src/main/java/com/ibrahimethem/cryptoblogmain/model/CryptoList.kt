package com.ibrahimethem.cryptoblogmain.model

import com.google.gson.annotations.SerializedName

data class CryptoList(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("status")
    val status: Status?
)