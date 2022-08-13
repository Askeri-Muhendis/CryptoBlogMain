package com.ibrahimethem.cryptoblogmain.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD")
    val uSD: USD?
)