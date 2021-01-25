package com.app.spacez.di.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase

abstract class RocketDatabase : RoomDatabase() {
    abstract fun rocketDao(): RocketDao
}