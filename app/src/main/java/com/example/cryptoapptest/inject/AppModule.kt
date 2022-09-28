package com.example.cryptoapptest.inject

import android.content.Context
import com.example.cryptoapptest.data.local.AppDatabase
import com.example.cryptoapptest.data.local.CryptoDAO
import com.example.cryptoapptest.data.remote.CryptoService
import com.example.cryptoapptest.data.remote.RemoteDataSource
import com.example.cryptoapptest.data.repository.CryptoRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGSON(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.coincap.io/v2/")
        .addConverterFactory((GsonConverterFactory.create(gson)))
        .build()

    @Provides
    fun provideCryptoService(retrofit: Retrofit): CryptoService =
        retrofit.create(CryptoService::class.java)

    @Singleton
    @Provides
    fun provideCryptoRemoteDataSource(cryptoService: CryptoService)=
        RemoteDataSource(cryptoService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCryptoDAO(appDatabase: AppDatabase) =
        appDatabase.cryptoDAO()


    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource, localDataSource: CryptoDAO)
            = CryptoRepo(remoteDataSource, localDataSource)

}