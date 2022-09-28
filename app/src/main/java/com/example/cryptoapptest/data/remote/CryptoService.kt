package com.example.cryptoapptest.data.remote

import com.example.cryptoapptest.data.entites.Data
import com.example.cryptoapptest.data.entites.Items
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoService {

    @GET("assets")
    suspend fun getAllCrypto(): Response<Items>

    /**
     * service for retrieving details
     */

    /*
    @GET("assets/{ID}")
    suspend fun getCryptoDetails(@Path("id")id:String): Response<Data>


     */

}