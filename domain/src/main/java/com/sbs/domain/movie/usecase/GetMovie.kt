package com.sbs.domain.movie.usecase

import com.sbs.domain.movie.model.Movie
import com.sbs.domain.movie.model.MovieRequest
import com.sbs.domain.movie.repository.MovieRepository
import javax.inject.Inject

class GetMovie @Inject constructor(
    private val repo: MovieRepository
){
    suspend fun execute(request: MovieRequest): List<Movie>{
        return getMovieFromLocal(request).ifEmpty {
            val movies = getMovieFromNetwork(request)
            repo.addMovies(movies)
            getMovieFromLocal(request)
        }
    }

    private suspend fun getMovieFromLocal(request: MovieRequest): List<Movie> {
        return repo.getMoviesFromLocal(request)
    }

    private suspend fun getMovieFromNetwork(request: MovieRequest): List<Movie>{
        return repo.getMoviesFromNetwork(request)
    }
}