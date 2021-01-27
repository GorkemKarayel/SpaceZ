package com.app.spacez.ui.rocketdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.Rocket
import com.app.spacez.data.error
import com.app.spacez.data.loading
import com.app.spacez.data.success
import com.app.spacez.data.toMap
import com.app.spacez.data.RocketResponse
import com.app.spacez.repository.RocketsRepository
import com.app.spacez.repository.RocketsRepository.RocketCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RocketDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val rocketsRepository: RocketsRepository = RocketsRepository(application.applicationContext)
    val uiState = MutableLiveData<ResultHolder<Rocket>>()

    fun getRocketDetail(rocketId: String?) {
        uiState.value = loading()
        if (rocketId.isNullOrEmpty()) {
            uiState.value = error("")
            return
        }

        rocketsRepository.getRocket(rocketId, object : RocketCallback {
            override fun onSuccessRocket(rocket: RocketResponse?) {
                val rocketUiData = rocket?.toMap()
                uiState.value = success(rocketUiData)
            }

            override fun onFailRocket(throwable: Throwable) {
                uiState.value = error(throwable.message)
            }
        })
    }
}
