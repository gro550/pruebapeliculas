package com.game.pruebataxislibres.ui.adapter

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.game.pruebataxislibres.R
import com.game.pruebataxislibres.data.model.Movie
import com.game.pruebataxislibres.databinding.ItemMovieBinding
import com.game.pruebataxislibres.ui.movie_detail.MovieDetailActivity
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        this.context = parent.context
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movies[position]
        holder.bind(item, context)
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)
        fun bind(item: Movie, context: Context) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + item.posterPath)
                .into(binding.ivImageMovie)
            binding.tvNameMovie.text = item.originalTitle
            binding.cvMovie.setOnClickListener {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra("movie", item)
                context.startActivity(intent)
            }
        }
    }
}

