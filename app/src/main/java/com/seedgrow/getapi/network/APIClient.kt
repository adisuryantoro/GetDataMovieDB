package com.seedgrow.getapi.network

import android.app.Application
import android.content.Context
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class APIClient {
    private var retrofit: Retrofit
    var apiInterface: APIInterface? = null

    val BASEURL = "https://api.themoviedb.org/3/"

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiInterface = retrofit.create<APIInterface>(APIInterface::class.java)
    }

    fun getAPIInterface(): APIInterface? {
        return apiInterface
    }

}