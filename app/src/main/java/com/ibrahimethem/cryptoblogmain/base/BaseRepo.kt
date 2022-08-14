package com.ibrahimethem.cryptoblogmain.base


import com.ibrahimethem.cryptoblogmain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

import java.io.IOException


//Base Desing
abstract class BaseRepo {
    suspend fun <T> safeApiCall(
        apiToBeCalled : suspend () -> Response<T>
    ) : Resource<T> {
        //IO background thread için withContext(Dispatchers.IO)
        return withContext(Dispatchers.IO){
            try {
                val response : Response<T> = apiToBeCalled()
                val body = response.body()
                if (response.isSuccessful && body != null){
                    Resource.Success(body)
                }else{
                    Resource.Error(
                        errorCode = response.code(),
                        errorMessage = response.message()
                    )
                }
            }catch (io : IOException){
                Resource.Exception(
                    io
                )
            }catch (e : Throwable){
                Resource.Exception(
                    e
                )
            }
        }
    }
}