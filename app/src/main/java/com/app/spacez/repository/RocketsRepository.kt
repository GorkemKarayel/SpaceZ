package com.app.spacez.repository

import android.content.Context
import com.app.spacez.data.Rocket
import com.app.spacez.di.datasource.LocalDataStoreFactory
import com.app.spacez.di.datasource.RemoteDataStoreFactory
import com.app.spacez.di.datasource.local.RocketLocalDataSource
import com.app.spacez.di.datasource.remote.RocketRemoteDataSource

class RocketsRepository(applicationContext: Context) {

    private val remoteDataSource: RocketRemoteDataSource = RemoteDataStoreFactory.remoteDataSource
    private val localDataSource: RocketLocalDataSource =
        LocalDataStoreFactory.let { factory ->
            factory.applicationContext = applicationContext
            factory.localDataSource
        }

    suspend fun getAllRockets() : List<Rocket> {
       return remoteDataSource.rocketService.getAllRockets()
    }

    suspend fun getRocket(rocketId: String) : Rocket {
        return remoteDataSource.rocketService.getRocket(rocketId)
    }
}
