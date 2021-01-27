package com.app.spacez.repository

import com.app.spacez.data.RocketResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RocketService {
    @GET("rockets")
    fun getAllRockets(): Call<List<RocketResponse>>

    @GET("rockets/{rocket_id}")
    fun getRocket(@Path("rocket_id") rocketId: String): Call<RocketResponse>
}
