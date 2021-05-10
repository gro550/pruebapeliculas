package com.game.pruebataxislibres.data.repository

import com.game.pruebataxislibres.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("page") val page: Long,
    @SerializedName("results") val movies: List<Movie>
)
