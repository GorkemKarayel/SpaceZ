package com.app.spacez.di.datasource.remote


class RocketRemoteDataSource(private val rocketService: RocketService) {

    suspend fun getAllRockets() = rocketService.getAllRockets()

    suspend fun getRocket(rocketId: String) = rocketService.getRocket(rocketId)
}
