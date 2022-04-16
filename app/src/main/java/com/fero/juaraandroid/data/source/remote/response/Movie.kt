package com.fero.juaraandroid.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Movie(
    var id: Int = 0,
    @SerializedName("original_title") var title: String? = null,
    @SerializedName("overview") var overview: String? = null,
    @SerializedName("release_date") var date: String? = null,
    @SerializedName("poster_path")var poster: String? = null,
    @SerializedName("backdrop_path")var backdrop: String? = null
)