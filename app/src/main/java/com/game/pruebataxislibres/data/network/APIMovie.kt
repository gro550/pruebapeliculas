package com.game.pruebataxislibres.data.network

import com.game.pruebataxislibres.data.repository.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIMovie {
    @GET("discover/movie")
    suspend fun getAllMovie(@Query("api_key") api_key: String): Response<MovieResponse>
}