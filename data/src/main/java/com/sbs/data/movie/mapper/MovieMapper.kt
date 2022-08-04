package com.sbs.data.movie.mapper

import com.sbs.data.db.entity.MovieEntity
import com.sbs.domain.movie.model.Movie

object MovieMapper {

    fun List<Movie>.toMovieEntity(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        forEach {
            movies.add(
                MovieEntity(
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
                    isFavorite = it.isFavorite
                )
            )
        }

        return movies
    }
}