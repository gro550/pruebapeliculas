package com.game.pruebataxislibres.ui.fragment.movies

import android.content.Context
import com.game.pruebataxislibres.data.model.Movie

class MoviesPresenter : MoviesCore.Presenter {

    private lateinit var view: MoviesCore.View
    private lateinit var context: Context;
    private lateinit var model: MoviesCore.Model;

    constructor(view: MoviesCore.View, context: Context) {
        this.view = view;
        this.context = context;
        this.model = MoviesModel(this, context);
    }

    override fun setMovieList(movies: List<Movie>?) {
        view.setAdapterMovies(movies)
    }

    override fun showError(msg: String) {
        view.showError(msg)
    }
}