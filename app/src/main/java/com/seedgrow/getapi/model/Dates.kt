package com.seedgrow.getapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Dates(
    @SerializedName("maximum")
    @Expose
    var maximum: String? = null,
    @SerializedName("minimum")
    @Expose
    var minimum: String? = null
) : Serializable
