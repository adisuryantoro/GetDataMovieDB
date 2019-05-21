package com.seedgrow.getapi.network

import com.seedgrow.getapi.model.Movie
import com.seedgrow.getapi.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("movie/upcoming")
    fun getDataMovieUpcoming(@Query("api_key") api_key: String?): Call<Movie>
}