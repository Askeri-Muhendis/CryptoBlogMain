package com.ibrahimethem.cryptoblogmain.util.extensions

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

fun ImageView.downloadImage(imageUrl : String?){
    val placeHolder = generatePlaceHolder(this.context)
    this.load(imageUrl){
        crossfade(true)
        crossfade(500)
        placeholder(placeHolder)
    }
}

private fun generatePlaceHolder(context : Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 12f
        centerRadius = 40f
        start()
    }
}