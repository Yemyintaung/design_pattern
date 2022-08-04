package com.sbs.android.di

import com.sbs.android.features.movie.adapter.MovieAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideMovieAdapter() : MovieAdapter {
        return MovieAdapter()
    }
}