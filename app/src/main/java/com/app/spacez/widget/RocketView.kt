package com.app.spacez.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import com.app.spacez.R
import com.app.spacez.data.Rocket
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class RocketView @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val rocketImageView: ImageView
    private val rocketNameTextView: TextView
    private val rocketCountryTextView: TextView
    private val rocketCompanyTextView: TextView

    init {
        inflate(context, R.layout.view_rocket, this).run {
            rocketImageView = findViewById(R.id.rocketImageView)
            rocketNameTextView = findViewById(R.id.rocketNameTextView)
            rocketCountryTextView = findViewById(R.id.rocketCountryTextView)
            rocketCompanyTextView = findViewById(R.id.rocketCompanyTextView)
        }
    }

    fun renderRocket(rocket: Rocket) = with(rocket) {
        rocketNameTextView.text = context.getString(R.string.rocket_name, rocketName)
        rocketCountryTextView.text = context.getString(R.string.rocket_country, country)
        rocketCompanyTextView.text = context.getString(R.string.rocket_company, company)
        loadImage(images)
    }

    private fun loadImage(images: List<String>?) {
        if (images.isNullOrEmpty()) return

        Glide.with(this)
            .load(images.first())
            .centerCrop()
            .into(rocketImageView)
    }
}
