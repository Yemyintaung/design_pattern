package com.sbs.data.movie.mapper

import com.sbs.data.db.entity.MovieEntity
import com.sbs.domain.movie.model.Movie

object MovieEntityMapper {
    fun List<MovieEntity>.toMovie(): List<Movie> {
        val movies = ArrayList<Movie>()
        forEach {
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
                    category = it.category,
                    isFavorite = it.isFavorite,
                    cacheId = it.cacheId
                )
            )
        }
        return movies
    }
}