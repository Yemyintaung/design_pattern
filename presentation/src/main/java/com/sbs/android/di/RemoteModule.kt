package com.sbs.android.di

import com.sbs.data.movie.api.MovieApi
import com.sbs.data.movie.datasource.MovieDataSource
import com.sbs.data.movie.datasource.network.RemoteMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(
        service: MovieApi
    ): MovieDataSource {
        return RemoteMovieDataSource(service)
    }
}