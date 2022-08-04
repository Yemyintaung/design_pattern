package com.sbs.domain.movie.repository

import com.sbs.domain.movie.model.Movie
import com.sbs.domain.movie.model.MovieRequest

interface MovieRepository {
    suspend fun getMoviesFromNetwork(request: MovieRequest): List<Movie>
    suspend fun getMoviesFromLocal(request: MovieRequest): List<Movie>
    suspend fun addMovies(movies: List<Movie>)
}