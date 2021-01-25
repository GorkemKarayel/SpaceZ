package com.app.spacez.di.datasource.remote

import com.app.spacez.data.Rocket
import retrofit2.http.GET
import retrofit2.http.Path

interface RocketService {
    @GET("rockets")
    suspend fun getAllRockets(): List<Rocket>

    @GET("rockets/{rocket_id}")
    suspend fun getRocket(@Path("rocket_id") rocketId: String): Rocket
}
