package com.app.spacez.datasource

import com.app.spacez.repository.RocketService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RocketRemoteDataSource {

    private val rocketService = getRocketService()

    fun getAllRockets() = rocketService.getAllRockets()

    fun getRocket(rocketId: String) = rocketService.getRocket(rocketId)

    private fun getRocketService() : RocketService {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RocketService::class.java)
    }
}
