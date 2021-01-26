package com.app.spacez.repository

import android.content.Context
import com.app.spacez.data.Rocket
import com.app.spacez.data.toMap
import com.app.spacez.di.datasource.LocalDataStoreFactory
import com.app.spacez.di.datasource.RemoteDataStoreFactory
import com.app.spacez.di.datasource.local.RocketLocalDataSource
import com.app.spacez.di.datasource.remote.RocketRemoteDataSource

class RocketsRepository(applicationContext: Context) {

    private val remoteDataSource: RocketRemoteDataSource = RemoteDataStoreFactory.remoteDataSource
    private val localDataSource: RocketLocalDataSource = LocalDataStoreFactory.let { factory ->
        factory.applicationContext = applicationContext
        factory.localDataSource
    }

    suspend fun getAllRockets(): List<Rocket> {
        val localRockets = localDataSource.getAllRockets()
        return if (localRockets.isEmpty()) {
            val rockets = remoteDataSource.getAllRockets()
            rockets.flatMap { rocket -> listOf(rocket.toMap()) }
        } else {
            localRockets.flatMap { rocket -> listOf(rocket.toMap()) }
        }
    }

    suspend fun getRocket(rocketId: String): Rocket {
        val rocket = remoteDataSource.getRocket(rocketId)
        return rocket.toMap()
    }
}
