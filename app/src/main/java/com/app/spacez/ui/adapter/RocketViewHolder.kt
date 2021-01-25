package com.app.spacez.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.spacez.R
import com.app.spacez.data.Rocket
import com.app.spacez.widget.RocketView

class RocketViewHolder constructor(itemView: View) : ViewHolder(itemView) {

    private val rocketView: RocketView = itemView.findViewById(R.id.rocketView)

    fun bind(rocket: Rocket) {
        rocketView.renderRocket(rocket)
    }

    companion object {
        fun create(parent: ViewGroup): RocketViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rocket, parent, false)
            return RocketViewHolder(view)
        }
    }
}
