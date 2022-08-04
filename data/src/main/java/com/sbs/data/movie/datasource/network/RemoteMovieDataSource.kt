package com.sbs.data.movie.datasource.network

import com.sbs.data.BuildConfig
import com.sbs.data.movie.api.MovieApi
import com.sbs.data.movie.datasource.MovieDataSource
import com.sbs.data.movie.mapper.MovieResponseMapper.toMovie
import com.sbs.domain.movie.model.Movie
import com.sbs.domain.movie.model.MovieRequest
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor(
    private val api: MovieApi
) : MovieDataSource {
    override suspend fun getMovies(request: MovieRequest): List<Movie> {
        return api.fetchUpcomingMovies(BuildConfig.API_KEY).toMovie()
    }

    override suspend fun addMovies(movies: List<Movie>) {
        //
    }

}