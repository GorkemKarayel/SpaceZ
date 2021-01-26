package com.app.spacez.di.datasource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rocket(
    @PrimaryKey
    @ColumnInfo(name = "rocket_id") val id: String,
    @ColumnInfo(name = "rocket_name") val rocketName: String?,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "first_flight") val firstTip: String?,
    @ColumnInfo(name = "flickr_images") val images: List<String>?,
    @ColumnInfo(name = "company") val company: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "height") val height: Height,
    @ColumnInfo(name = "mass") val mass: Mass
)

data class Height(
    @ColumnInfo(name = "meters") val meters: Double,
    @ColumnInfo(name = "feet") val feet: Double
)

data class Mass(
    @ColumnInfo(name = "kg") val kg: Int,
    @ColumnInfo(name = "lb") val lb: Int
)