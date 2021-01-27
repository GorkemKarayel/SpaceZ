package com.app.spacez.ui.rockets

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.Rocket
import com.app.spacez.data.error
import com.app.spacez.data.loading
import com.app.spacez.data.success
import com.app.spacez.data.toMap
import com.app.spacez.data.RocketResponse
import com.app.spacez.repository.RocketsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RocketsViewModel(application: Application) : AndroidViewModel(application) {

    private val rocketRepository: RocketsRepository = RocketsRepository(application.applicationContext)
    val uiState = MutableLiveData<ResultHolder<List<Rocket>>>()

    init {
        getRocketList()
    }

    private fun getRocketList() {
        uiState.value = loading()
        rocketRepository.getAllRockets(object : Callback<List<RocketResponse>> {
            override fun onFailure(call: Call<List<RocketResponse>>, error: Throwable) {
                uiState.value = error(error.message)
            }

            override fun onResponse(call: Call<List<RocketResponse>>, response: Response<List<RocketResponse>>) {
                val rocketList = response.body()?.map { it.toMap() } ?: emptyList()
                uiState.value = success(rocketList)
            }
        })
    }
}
