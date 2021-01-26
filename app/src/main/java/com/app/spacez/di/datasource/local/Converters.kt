package com.app.spacez.di.datasource.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromImages(images: List<String?>?): String? {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(images, type)
    }

    @TypeConverter
    fun toImages(imagesString: String?): List<String>? {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson<List<String>>(imagesString, type)
    }

    @TypeConverter
    fun fromHeight(height: Height?): String? {
        val type = object : TypeToken<Height>() {}.type
        return Gson().toJson(height, type)
    }

    @TypeConverter
    fun toHeight(heightString: String?): Height? {
        val type = object : TypeToken<Height>() {}.type
        return Gson().fromJson<Height>(heightString, type)
    }

    @TypeConverter
    fun fromMass(mass: Mass?): String? {
        val type = object : TypeToken<Mass>() {}.type
        return Gson().toJson(mass, type)
    }

    @TypeConverter
    fun toMass(massString: String?): Mass? {
        val type = object : TypeToken<Mass>() {}.type
        return Gson().fromJson<Mass>(massString, type)
    }
}