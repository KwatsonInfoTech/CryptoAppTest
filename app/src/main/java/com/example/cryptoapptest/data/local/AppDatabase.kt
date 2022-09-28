package com.example.cryptoapptest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapptest.data.entites.Data

@Database(entities = [com.example.cryptoapptest.data.entites.Data::class], version = 3, exportSchema = false)
abstract class AppDatabase :RoomDatabase() {

    abstract fun cryptoDAO():CryptoDAO

    companion object{
        @Volatile private var INSTANCE: AppDatabase?= null

        fun getDatabase(context: Context) : AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "CryptoDB3")
                .fallbackToDestructiveMigration()
                .build()
    }

}