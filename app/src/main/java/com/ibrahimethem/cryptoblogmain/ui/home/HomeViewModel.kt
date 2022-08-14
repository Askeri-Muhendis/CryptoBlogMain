package com.ibrahimethem.cryptoblogmain.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimethem.cryptoblogmain.model.CryptoList
import com.ibrahimethem.cryptoblogmain.repo.CryptoRepo
import com.ibrahimethem.cryptoblogmain.util.Consts.API_KEY
import com.ibrahimethem.cryptoblogmain.util.Consts.LIMIT
import com.ibrahimethem.cryptoblogmain.util.Resource
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.Response

class HomeViewModel(private val cryptoRepo : CryptoRepo) : ViewModel() {
    private val _cryptoList = MutableLiveData<CryptoList?>()
    val cryptoList : LiveData<CryptoList?> = _cryptoList

    private val _cryptoError = MutableLiveData<String?>()
    val cryptoError : LiveData<String?> = _cryptoError

    fun getCryptoAll(){
        viewModelScope.launch {
            val requestApi  = cryptoRepo.getAllCrypto(API_KEY,LIMIT)
            when(requestApi){
                is Resource.Success -> {
                    _cryptoList.value = requestApi.data
                }
                is Resource.Error -> {
                    _cryptoError.value = "Hata Kodu:${requestApi.errorCode} ${requestApi.errorMessage}"
                }
                is Resource.Exception -> {
                    _cryptoError.value = "Hata ${requestApi.exception}"
                }
            }
        }
    }
    /*try {
                val requestApi  = cryptoRepo.getAllCrypto(API_KEY,LIMIT)
                if (requestApi.isSuccessful){
                    _cryptoList.postValue(requestApi)
                }else{
                    _cryptoError.postValue(requestApi.code().toString())
                }
            }catch (e : Exception){

            }*/
}