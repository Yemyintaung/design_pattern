package com.sbs.data.movie.api

import androidx.annotation.WorkerThread
import com.sbs.data.BuildConfig.API_KEY
import com.sbs.data.movie.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @WorkerThread
    @GET("/upcoming")
    suspend fun fetchUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 0/*STARTING_PAGE_INDEX*/,
        @Query("language") language: String = "en"
    ): MovieResponse
}