package com.game.pruebataxislibres.ui.fragment.movies

import com.game.pruebataxislibres.data.model.Movie
import com.game.pruebataxislibres.utils.core.CorePresenter
import com.game.pruebataxislibres.utils.core.CoreView

interface MoviesCore {
    interface View : CoreView {
        fun setAdapterMovies(movies: List<Movie>?)
    }

    interface Presenter : CorePresenter {
        fun setMovieList(movies: List<Movie>?)
    }

    interface Model {
        fun getMovies()
    }
}