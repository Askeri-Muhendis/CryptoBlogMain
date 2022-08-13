package com.ibrahimethem.cryptoblogmain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimethem.cryptoblogmain.repo.CryptoRepo
import com.ibrahimethem.cryptoblogmain.ui.home.HomeViewModel

class ViewModelFactory(
    private val repo : CryptoRepo
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}