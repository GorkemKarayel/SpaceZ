package com.app.spacez

import android.app.Application
import com.app.spacez.di.ApplicationComponent

class SpaceApplication : Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = ApplicationComponent()
    }
}
