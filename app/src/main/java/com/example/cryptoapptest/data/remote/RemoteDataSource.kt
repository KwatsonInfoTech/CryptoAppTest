package com.example.cryptoapptest.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val cryptoService: CryptoService) :
    BaseDataSource() {

        suspend fun getCrypto() = getResult { cryptoService.getAllCrypto() }

}