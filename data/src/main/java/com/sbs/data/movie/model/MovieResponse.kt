package com.sbs.data.movie.model

data class MovieResponse(
    val code: Int? = null,
    val status : String? = null,
    val data: List<MovieDto>,
)