package com.sbs.data.movie.factory

import com.sbs.data.movie.datasource.MovieDataSource
import com.sbs.data.movie.datasource.local.LocalMovieDataSource
import com.sbs.data.movie.datasource.network.RemoteMovieDataSource
import com.sbs.data.utils.Source
import javax.inject.Inject

class MovieFactory @Inject constructor(
    private val remote: RemoteMovieDataSource,
    private val local: LocalMovieDataSource,
){
    fun create(source: Source): MovieDataSource {
        return when(source){
            Source.NETWORK -> remote
            else -> local
        }
    }
}