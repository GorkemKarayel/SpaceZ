package com.app.spacez.di.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Rocket::class], version = 1)
@TypeConverters(Converters::class)
abstract class RocketDatabase : RoomDatabase() {
    abstract fun rocketDao(): RocketDao
}