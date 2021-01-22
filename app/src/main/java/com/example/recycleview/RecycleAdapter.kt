package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(private val items: List<Pair<Person, Int>>) :
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(list: Pair<Person, Int>) {
            itemView.apply {
                updatePadding((list.second - 1) * 125 + 50)
                findViewById<TextView>(R.id.tvPersonName).text = list.first.name
                findViewById<TextView>(R.id.tvPersonAge).text = list.first.age.toString()
            }
        }
    }
}

