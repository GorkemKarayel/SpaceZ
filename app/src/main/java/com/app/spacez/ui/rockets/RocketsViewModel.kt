package com.app.spacez.ui.rockets

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

class RocketsViewModel(application: Application) : AndroidViewModel(application) {

    private val rocketsRepository: RocketsRepository = RocketsRepository(application)
    val uiState = MutableLiveData<ResultHolder<List<Rocket>>>()

    init {
        getRockets()
    }

    private fun getRockets() {
        uiState.value = loading()
        viewModelScope.launch {
            try {
                val rockets = rocketsRepository.getAllRockets()
                uiState.value = success(rockets)
            }catch (exception: Exception) {
                uiState.value = error(exception.message)
            }
        }
    }
}
