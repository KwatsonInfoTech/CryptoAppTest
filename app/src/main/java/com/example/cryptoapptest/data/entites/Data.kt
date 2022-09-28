package com.example.cryptoapptest.data.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Crypto_Details")
data class Data(

    @PrimaryKey
    val id: String,
    val changePercent24Hr: String?,
    val explorer: String?,
    val marketCapUsd: String?,
    val maxSupply: String?,
    val name: String?,
    val priceUsd: String?,
    val rank: String?,
    val supply: String?,
    val symbol: String?,
    val volumeUsd24Hr: String?,
    val vwap24Hr: String?
)