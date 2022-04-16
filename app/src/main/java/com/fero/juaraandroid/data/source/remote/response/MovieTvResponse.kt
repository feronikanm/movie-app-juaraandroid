package com.fero.juaraandroid.data.source.remote.response

data class MovieTvResponse<T>(
    var page: Int,
    var results: List<T>,
    var totalPages: Int,
    var totalResults: Int
)
