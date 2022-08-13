package com.ibrahimethem.cryptoblogmain.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimethem.cryptoblogmain.model.CryptoList
import com.ibrahimethem.cryptoblogmain.repo.CryptoRepo
import com.ibrahimethem.cryptoblogmain.util.Consts.API_KEY
import com.ibrahimethem.cryptoblogmain.util.Consts.LIMIT
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val cryptoRepo : CryptoRepo) : ViewModel() {
    private val _cryptoList = MutableLiveData<Response<CryptoList>>()
    val cryptoList : LiveData<Response<CryptoList>> = _cryptoList

    fun getCryptoAll(){
        viewModelScope.launch {
            _cryptoList.postValue(cryptoRepo.getAllCrypto(API_KEY,LIMIT))
        }
    }
}