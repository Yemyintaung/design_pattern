package com.sbs.android.features.movie.mapper

import com.sbs.android.features.movie.model.MovieUiModel
import com.sbs.domain.movie.model.Movie

object MovieUiModelMapper {

    fun List<Movie>.toUiModel(): List<MovieUiModel> {
        val movies = ArrayList<MovieUiModel>()

        forEach {
            movies.add(
                MovieUiModel(
                    title = it.title,
                    category = it.category,
                    date = it.releaseDate
                )
            )
        }

        return movies
    }
}