package com.game.pruebataxislibres.ui.fragment.movies

import android.content.Context
import com.game.pruebataxislibres.data.network.APIMovie
import com.game.pruebataxislibres.data.network.RetrofitInstance
import com.game.pruebataxislibres.data.repository.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesModel : MoviesCore.Model {
    private val key: String = "5ba88ec64e488d217203b69b1eb3555e";
    private lateinit var presenter: MoviesCore.Presenter
    private lateinit var context: Context;

    constructor(presenter: MoviesCore.Presenter, context: Context) {
        this.presenter = presenter;
        this.context = context;
        getMovies()
    }

    override fun getMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call: Response<MovieResponse>? =
                    RetrofitInstance().movie().create(APIMovie::class.java)
                        .getAllMovie(key)
                val result: MovieResponse? = call?.body()
                if (call?.isSuccessful!!) {
                    presenter.setMovieList(result?.movies);
                }
            } catch (e: Exception) {
                presenter.showError("SIN INTERNET")
            }
        }
    }
}
