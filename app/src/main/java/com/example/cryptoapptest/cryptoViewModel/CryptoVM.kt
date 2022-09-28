package com.example.cryptoapptest.cryptoViewModel

import androidx.lifecycle.ViewModel
import com.example.cryptoapptest.data.repository.CryptoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoVM @Inject constructor(repo: CryptoRepo):ViewModel() {

    val repository = repo.getCrypto()


}