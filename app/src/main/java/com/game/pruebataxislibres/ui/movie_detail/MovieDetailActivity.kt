package com.game.pruebataxislibres.ui.movie_detail

import android.os.Bundle
import com.game.pruebataxislibres.data.model.Movie
import com.game.pruebataxislibres.utils.mvp.BaseView
import com.game.pruebataxislibres.databinding.ActivityMovieDetailBinding
import com.squareup.picasso.Picasso

class MovieDetailActivity : BaseView() {
    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var movie: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movie = intent.extras?.getSerializable("movie") as Movie
        initView()
    }

    private fun initView() {
        binding.tvTitle.text = movie.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(binding.ivBackground)
        binding.tvSummaryMovie.text = movie.overview
    }

}