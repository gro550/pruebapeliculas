package com.game.pruebataxislibres.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitInstance {

    fun movie(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}