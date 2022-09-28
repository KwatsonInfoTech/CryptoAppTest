package com.example.cryptoapptest.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapptest.data.entites.Data
import com.example.cryptoapptest.data.entites.Items

@Dao
interface CryptoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(result: List<Data>)

    @Query("SELECT * FROM Crypto_Details")
     fun getAllCrypto(): LiveData<List<Data>>

}