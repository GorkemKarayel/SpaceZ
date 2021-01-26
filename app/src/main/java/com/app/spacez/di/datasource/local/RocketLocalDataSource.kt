package com.app.spacez.di.datasource.local

class RocketLocalDataSource(private val rocketDatabase: RocketDatabase) {

    suspend fun getAllRockets() = rocketDatabase.rocketDao().getAllRockets()
}
