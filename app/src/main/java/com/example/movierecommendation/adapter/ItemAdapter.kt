package com.example.movierecommendation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecommendation.R
import com.example.movierecommendation.module.MovieCard


class ItemAdapter(
    private val context: Context,
    private val dataset: List<MovieCard>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView2: TextView = view.findViewById(R.id.item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item4, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
//        holder.textView.text = context.resources.getString(item.stringResourceId)
//        holder.imageView.setImageResource(item.imageResourceId)
//        holder.textView2.text = context.resources.getString(item.stringResourceId2)
        holder.textView.text = context.resources.getString(item.nameRu.toInt())
        holder.imageView.setImageResource(R.drawable.movie_brat)
        holder.textView2.text = context.resources.getString(item.shortDescription.toInt())
    }

    override fun getItemCount() = dataset.size
}