package com.game.pruebataxislibres.ui.fragment.movies

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.game.pruebataxislibres.R
import com.game.pruebataxislibres.data.model.Movie
import com.game.pruebataxislibres.databinding.FragmentMovieBinding
import com.game.pruebataxislibres.ui.adapter.MovieAdapter
import com.game.pruebataxislibres.utils.mvp.BaseFragmentView

class MoviesFragment : BaseFragmentView<FragmentMovieBinding>(R.layout.fragment_movie),
    MoviesCore.View {
    private lateinit var presenter: MoviesCore.Presenter
    private lateinit var adapter: MovieAdapter
    private var movies = mutableListOf<Movie>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingInit = FragmentMovieBinding.bind(view)
        presenter = MoviesPresenter(this, this.requireContext())
        showProgress(R.raw.movie)
    }

    override fun setAdapterMovies(movies: List<Movie>?) {
        this.movies = movies as MutableList<Movie>
        if (movies != null) {
            this.activity?.runOnUiThread {
                hideProgress()
                adapter = MovieAdapter(movies)
                binding.rvMovies.layoutManager = GridLayoutManager(this.requireContext(), 2)
                binding.rvMovies.adapter = adapter
            }
        }
    }

}