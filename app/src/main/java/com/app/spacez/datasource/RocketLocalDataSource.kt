package com.app.spacez.datasource

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.app.spacez.data.RocketResponse
import com.google.gson.Gson

class RocketLocalDataSource(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("rocket_db", MODE_PRIVATE)

    fun addRocket(rocket: RocketResponse?) {
        val editor = sharedPreferences.edit()
        val json = Gson().toJson(rocket)
        editor.putString(rocket?.id, json).apply()
    }

    fun getRocket(rocketId: String): RocketResponse? {
        return try {
            val json = sharedPreferences.getString(rocketId, null)
            Gson().fromJson(json, RocketResponse::class.java)
        } catch (exception: Exception) {
            null
        }
    }
}
