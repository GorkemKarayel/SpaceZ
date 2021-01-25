package com.app.spacez.di

import androidx.fragment.app.FragmentActivity
import com.app.spacez.di.navigator.SpaceNavigator
import com.app.spacez.di.navigator.SpaceNavigatorImpl

class ApplicationComponent {
    fun provideNavigator(activity: FragmentActivity) : SpaceNavigator {
        return SpaceNavigatorImpl(activity)
    }
}
