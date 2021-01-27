package com.app.spacez.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.app.spacez.data.Rocket

class RocketAdapter(
    diffCallback: ItemCallback<Rocket>,
    private val rocketListener: (Rocket) -> Unit
) : ListAdapter<Rocket, RocketViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val viewHolder = RocketViewHolder.create(parent)
        viewHolder.itemView.setOnClickListener {
            rocketListener.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val rocket: Rocket = getItem(position)
        holder.bind(rocket)
    }

    internal class RocketDiff : ItemCallback<Rocket>() {
        override fun areItemsTheSame(oldItem: Rocket, newItem: Rocket): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Rocket, newItem: Rocket): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
