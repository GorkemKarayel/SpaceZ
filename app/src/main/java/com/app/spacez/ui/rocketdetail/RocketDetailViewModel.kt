package com.app.spacez.ui.rocketdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.Rocket
import com.app.spacez.data.error
import com.app.spacez.data.loading
import com.app.spacez.data.success
import com.app.spacez.repository.RocketsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class RocketDetailViewModel(application: Application) : AndroidViewModel(application) {

    private var rocketsRepository: RocketsRepository = RocketsRepository(application)
    val uiState = MutableLiveData<ResultHolder<Rocket>>()

    fun getRocketDetail(rocketId: String?) {
        uiState.value = loading()
        if (rocketId.isNullOrEmpty()) {
            uiState.value = error("")
            return
        }

        viewModelScope.launch {
            try {
               val rocket = rocketsRepository.getRocket(rocketId)
                uiState.value = success(rocket)
            } catch (exception: Exception) {
                uiState.value = error(exception.message)
            }
        }
    }
}
