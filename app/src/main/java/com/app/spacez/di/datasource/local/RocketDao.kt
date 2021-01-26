package com.app.spacez.di.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RocketDao {
    @Query("SELECT * FROM rocket")
    suspend fun getAllRockets(): List<Rocket>

    @Insert
    suspend fun insertAll(vararg rockets: Rocket)
}