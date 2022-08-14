package com.ibrahimethem.cryptoblogmain.repo

import com.ibrahimethem.cryptoblogmain.base.BaseRepo
import com.ibrahimethem.cryptoblogmain.model.CryptoList
import com.ibrahimethem.cryptoblogmain.network.CryptoService
import com.ibrahimethem.cryptoblogmain.util.Resource
import okio.IOException
import retrofit2.Response

class CryptoRepo(private val cryptoService : CryptoService)  : BaseRepo(){
    suspend fun getAllCrypto(apiKey : String,limit : String) : Resource<CryptoList> {
        return safeApiCall {
            //throw IOException()
            cryptoService.getAllCryptoList(apiKey,limit)
        }
    }
}