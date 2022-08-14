package com.ibrahimethem.cryptoblogmain.util


sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val errorCode: Int, val errorMessage: String) : Resource<T>()
    class Exception<T>(val exception: Throwable) : Resource<T>()
}

