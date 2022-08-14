package com.ibrahimethem.cryptoblogmain.repo

import com.ibrahimethem.cryptoblogmain.model.CryptoList
import com.ibrahimethem.cryptoblogmain.network.CryptoService
import okio.IOException
import retrofit2.Response

class CryptoRepo(private val cryptoService : CryptoService) {
    suspend fun getAllCrypto(apiKey : String,limit : String) : Response<CryptoList> {
        //throw IOException()
        return cryptoService.getAllCryptoList(apiKey,limit)
    }
}