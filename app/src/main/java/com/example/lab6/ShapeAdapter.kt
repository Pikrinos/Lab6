package com.example.lab6

import android.graphics.Color
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ShapeAdapter(private val inflater: LayoutInflater,private val onClick: (MainActivity.Shape)-> Unit): ListAdapter<MainActivity.Shape, ShapeAdapter.ViewHolder>(PlaceDiffCallback) {


    class ViewHolder(view: View,onClick: (MainActivity.Shape) -> Unit) : RecyclerView.ViewHolder(view) {
        private val number = view.findViewById<TextView>(R.id.number)
        private val color = view.rootView
        private var shape : MainActivity.Shape? = null

        init {
            view.setOnClickListener {
                shape?.let {
                    onClick(it)
                }
            }
        }
        fun bind(shape: MainActivity.Shape){
            this.shape = shape
            number.text = shape.number.toString()
            color.setBackgroundColor(Color.parseColor(shape.color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.shape,parent,false)
        return ViewHolder(view,onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = getItem(position)
        holder.bind(place)
    }

    object PlaceDiffCallback : DiffUtil.ItemCallback<MainActivity.Shape>(){
        override fun areItemsTheSame(
            oldItem: MainActivity.Shape,
            newItem: MainActivity.Shape
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainActivity.Shape,
            newItem: MainActivity.Shape
        ): Boolean = oldItem.number == newItem.number && oldItem.color == newItem.color

    }
}