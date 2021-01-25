package com.app.spacez.di.navigator

import androidx.fragment.app.FragmentActivity
import com.app.spacez.R
import com.app.spacez.ui.rocketdetail.RocketDetailFragment.RocketDetailFragmentFactory
import com.app.spacez.ui.rockets.RocketsFragment

class SpaceNavigatorImpl constructor(private val activity: FragmentActivity) : SpaceNavigator {
    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.Rockets -> RocketsFragment()
            is Screens.RocketDetail -> RocketDetailFragmentFactory.newInstance(screen.rocketId)
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}
