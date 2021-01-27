package com.app.spacez.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.app.spacez.R

fun FragmentActivity.addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(fragment::class.java.canonicalName)
        .commit()
}
