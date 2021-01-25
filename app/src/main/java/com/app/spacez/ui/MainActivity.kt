package com.app.spacez.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.spacez.SpaceApplication
import com.app.spacez.databinding.ActivityMainBinding
import com.app.spacez.di.navigator.Screens
import com.app.spacez.di.navigator.SpaceNavigator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val navigator: SpaceNavigator by lazy {
        (applicationContext as SpaceApplication)
            .applicationComponent
            .provideNavigator(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.Rockets)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
