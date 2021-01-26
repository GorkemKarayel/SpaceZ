package com.app.spacez.data

import com.app.spacez.di.datasource.local.Rocket as LocalRocket
import com.app.spacez.di.datasource.remote.Rocket as RemoteRocket

data class Rocket(
    val id: String,
    val rocketName: String?,
    val country: String?,
    val firstTip: String?,
    val images: List<String>?,
    val company: String?,
    val description: String?,
    val height: Height,
    val mass: Mass
)

data class Height(
    val meters: Double,
    val feet: Double
)

data class Mass(
    val kg: Int,
    val lb: Int
)

fun LocalRocket.toMap(): Rocket {
    val height = Height(height.meters, height.feet)
    val mass = Mass(mass.kg, mass.lb)
    return Rocket(id, rocketName, country, firstTip, images, company, description, height, mass)
}

fun RemoteRocket.toMap(): Rocket {
    val height = Height(height.meters, height.feet)
    val mass = Mass(mass.kg, mass.lb)
    return Rocket(id, rocketName, country, firstTip, images, company, description, height, mass)
}