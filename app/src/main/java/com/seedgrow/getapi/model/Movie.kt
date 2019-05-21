package com.seedgrow.getapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null,
    @SerializedName("page")
    @Expose
    var page: Int? = null,
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null,
    @SerializedName("dates")
    @Expose
    var dates: Dates? = null,
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
) : Serializable