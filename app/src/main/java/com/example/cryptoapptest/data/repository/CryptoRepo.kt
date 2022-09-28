package com.example.cryptoapptest.data.repository

import com.example.cryptoapptest.data.local.CryptoDAO
import com.example.cryptoapptest.data.remote.RemoteDataSource
import com.example.cryptoapptest.utils.performGetOperation
import javax.inject.Inject

class CryptoRepo @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                     private val localDataSource: CryptoDAO) {

    fun getCrypto() = performGetOperation(
        databaseQuery = {localDataSource.getAllCrypto()},
        networkCall = {remoteDataSource.getCrypto()},
        saveCallResult = {localDataSource.insertAll(it.data)}

    )




}