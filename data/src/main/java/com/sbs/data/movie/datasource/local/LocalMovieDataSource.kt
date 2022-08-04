package com.sbs.data.movie.datasource.local

import com.sbs.data.db.dao.MovieDao
import com.sbs.data.movie.datasource.MovieDataSource
import com.sbs.domain.movie.model.Movie
import com.sbs.data.movie.mapper.MovieEntityMapper.toMovie
import com.sbs.data.movie.mapper.MovieMapper.toMovieEntity
import com.sbs.domain.movie.model.MovieRequest
import javax.inject.Inject

class LocalMovieDataSource @Inject constructor(
    private val dao: MovieDao
) : MovieDataSource {
    override suspend fun getMovies(request: MovieRequest): List<Movie> {
        return dao.getMovies(request.date).toMovie()
    }

    override suspend fun addMovies(movies: List<Movie>) {
        dao.saveMovies(movies.toMovieEntity())
    }

}