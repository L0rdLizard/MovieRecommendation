
package com.example.movierecommendation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movierecommendation.MoviesListFragment
import com.example.movierecommendation.R
import com.example.movierecommendation.databinding.ListItem4Binding
import com.example.movierecommendation.module.MovieCard
import com.example.movierecommendation.network.objKinopoiskAPI
import kotlinx.coroutines.launch

class MovieAdapter(private val onItemClicked: (MovieCard) -> Unit) :
    ListAdapter<MovieCard, MovieAdapter.MoviesViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class MoviesViewHolder(private var binding: ListItem4Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieCard, context:Context) {
            println("!!!!!!!!!!!!!!!!!!!!!!!!MovieAdapter is working")

            binding.itemTitle.text = movie.nameRu
            binding.itemDescription.text = movie.shortDescription
            binding.itemImage.load(movie.posterUrlPreview) {
                crossfade(true)
                placeholder(R.drawable.placeholder)
                error(R.drawable.error)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {

        context = parent.context
        return MoviesViewHolder(
            ListItem4Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            println(current)
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<MovieCard>() {
            override fun areItemsTheSame(oldItem: MovieCard, newItem: MovieCard): Boolean {
//                return (oldItem.stringResourceId == newItem.stringResourceId ||
//                        oldItem.stringResourceId2 == newItem.stringResourceId2
//                        )
                return (oldItem.nameRu == newItem.nameRu ||
                        oldItem.shortDescription == newItem.shortDescription
                        )
            }

            override fun areContentsTheSame(oldItem: MovieCard, newItem: MovieCard): Boolean {
                return oldItem == newItem
            }
        }
    }
}
