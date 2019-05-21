package com.seedgrow.getapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.seedgrow.getapi.adapter.MovieAdapter
import com.seedgrow.getapi.model.Movie
import com.seedgrow.getapi.model.Result
import com.seedgrow.getapi.network.APIClient
import com.seedgrow.getapi.network.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var linearLayoutManager: LinearLayoutManager? = null
    var recyclerView: RecyclerView? = null
    var responseMovies: MutableList<Result>? = null
    var listMovieAdapter: MovieAdapter? = null
    var apiClient: APIClient? = null
    var api_key: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        responseMovies = ArrayList()

        recyclerView = findViewById(R.id.rv_list_movie_db)
        recyclerView?.setHasFixedSize(true)

        apiClient = APIClient()

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.setLayoutManager(linearLayoutManager)

        listMovieAdapter = MovieAdapter()
        recyclerView?.setAdapter(listMovieAdapter)

        api_key = getString(R.string.api_key)

        doAPICallMovie()
    }

    private fun doAPICallMovie() {
        apiClient?.getAPIInterface()?.getDataMovieUpcoming(api_key)?.enqueue(object : Callback<Movie>{
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Toast.makeText(getApplicationContext(), "Get Movie List Failed", Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                listMovieAdapter?.setDataMovies(response!!.body()!!.results as MutableList<Result>?)
            }

        })
    }
}
