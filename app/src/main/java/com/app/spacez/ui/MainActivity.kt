package com.app.spacez.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.spacez.R
import com.app.spacez.ui.rockets.RocketsFragment
import com.app.spacez.utils.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            this@MainActivity.addFragment(RocketsFragment())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
