package com.sbs.data.movie.mapper

import com.sbs.data.movie.model.MovieResponse
import com.sbs.domain.movie.model.Movie

object MovieResponseMapper {
    fun MovieResponse.toMovie(): List<Movie> {
        val movies = ArrayList<Movie>()
        data.forEach {
            movies.add(
                Movie(
                    adult = it.adult,
                    backdropPath = it.backdropPath,
                    /*genreIds = it.genreIds,*/
                    id = it.id,
                    originalLanguage = it.originalLanguage,
                    originalTitle = it.originalTitle,
                    overview = it.overview,
                    popularity = it.popularity,
                    posterPath = it.posterPath,
                    releaseDate = it.releaseDate,
                    title = it.title,
                    video = it.video,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount,
                    category = "",
                    isFavorite = false,
                    cacheId = 0
                )
            )
        }
        return movies
    }
}