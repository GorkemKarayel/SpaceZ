package com.app.spacez.di.navigator

sealed class Screens(val rocketId: String? = null) {
    object Rockets: Screens()
    data class RocketDetail(val id: String): Screens(id)
}

interface SpaceNavigator {
    fun navigateTo(screen: Screens)
}
