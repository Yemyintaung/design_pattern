package com.sbs.data.movie.datasource

import com.sbs.domain.movie.model.Movie
import com.sbs.domain.movie.model.MovieRequest

interface MovieDataSource {
    suspend fun getMovies(request: MovieRequest): List<Movie>
    suspend fun addMovies(movies: List<Movie>)
}