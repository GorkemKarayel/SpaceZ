package com.app.spacez.di.datasource.remote

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("rocket_id") val id: String,
    @SerializedName("rocket_name") val rocketName: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("first_flight") val firstTip: String?,
    @SerializedName("flickr_images") val images: List<String>?,
    @SerializedName("company") val company: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("height") val height: Height,
    @SerializedName("mass") val mass: Mass
)

data class Height(
    @SerializedName("meters") val meters: Double,
    @SerializedName("feet") val feet: Double
)

data class Mass(
    @SerializedName("kg") val kg: Int,
    @SerializedName("lb") val lb: Int
)