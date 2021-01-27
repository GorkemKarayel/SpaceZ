package com.app.spacez.repository

import android.content.Context
import com.app.spacez.datasource.RocketRemoteDataSource
import com.app.spacez.data.RocketResponse
import com.app.spacez.datasource.RocketLocalDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RocketsRepository(applicationContext: Context) {

    private val remoteDataSource = RocketRemoteDataSource()
    private val localDataSource = RocketLocalDataSource(applicationContext)

    fun getAllRockets(callback: Callback<List<RocketResponse>>) {
        remoteDataSource.getAllRockets().enqueue(callback)
    }

    fun getRocket(rocketId: String, rocketCallback: RocketCallback) {
        val localRocket = localDataSource.getRocket(rocketId)
        if (localRocket == null) {
            remoteDataSource.getRocket(rocketId).enqueue(object : Callback<RocketResponse> {
                override fun onFailure(call: Call<RocketResponse>, t: Throwable) {
                    rocketCallback.onFailRocket(t)
                }

                override fun onResponse(
                    call: Call<RocketResponse>,
                    response: Response<RocketResponse>
                ) {
                    localDataSource.addRocket(response.body())
                    rocketCallback.onSuccessRocket(response.body())
                }
            })
        } else {
            rocketCallback.onSuccessRocket(localRocket)
        }
    }

    interface RocketCallback {
        fun onSuccessRocket(rocket: RocketResponse?)
        fun onFailRocket(throwable: Throwable)
    }
}
