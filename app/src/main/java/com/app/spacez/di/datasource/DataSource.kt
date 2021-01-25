package com.app.spacez.di.datasource

import android.content.Context
import com.app.spacez.di.datasource.local.RocketLocalDataSource
import com.app.spacez.di.datasource.remote.RocketRemoteDataSource
import com.app.spacez.di.datasource.remote.RocketService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataStoreFactory {
    private val rocketService = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RocketService::class.java)

    val remoteDataSource = RocketRemoteDataSource(rocketService)
}

object LocalDataStoreFactory {
    lateinit var applicationContext: Context
    /*
       private val rocketDatabase = Room.databaseBuilder(
        applicationContext,
        RocketDatabase::class.java,
        "rockets.db"
    ).build()
     */
    val localDataSource = RocketLocalDataSource()
}
