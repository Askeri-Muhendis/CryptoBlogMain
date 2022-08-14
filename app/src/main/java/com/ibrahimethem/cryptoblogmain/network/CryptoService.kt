package com.ibrahimethem.cryptoblogmain.network

import com.ibrahimethem.cryptoblogmain.model.CryptoList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CryptoService {
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getAllCryptoList(
        @Header("X-CMC_PRO_API_KEY") apiKey : String,
        @Query("limit") limit : String
    ) : Response<CryptoList>
}