package com.sbs.data.movie.repository

import com.sbs.data.movie.factory.MovieFactory
import com.sbs.data.utils.Source
import com.sbs.domain.movie.model.Movie
import com.sbs.domain.movie.model.MovieRequest
import com.sbs.domain.movie.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val factory: MovieFactory
) : MovieRepository {
    override suspend fun getMoviesFromNetwork(request: MovieRequest): List<Movie> {
        return factory.create(Source.NETWORK).getMovies(request)
    }

    override suspend fun getMoviesFromLocal(request: MovieRequest): List<Movie> {
        return factory.create(Source.LOCAL).getMovies(request)
    }

    override suspend fun addMovies(movies: List<Movie>) {
        factory.create(Source.LOCAL).addMovies(movies)
    }
}