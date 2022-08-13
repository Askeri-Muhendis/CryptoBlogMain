package com.ibrahimethem.cryptoblogmain.repo

import com.ibrahimethem.cryptoblogmain.model.CryptoList
import com.ibrahimethem.cryptoblogmain.network.CryptoService
import retrofit2.Response

class CryptoRepo(private val cryptoService : CryptoService) {
    suspend fun getAllCrypto(apiKey : String,limit : String) : Response<CryptoList> {
        return cryptoService.getAllCryptoList(apiKey,limit)
    }
}