package com.sbs.android.di

import com.sbs.data.db.dao.MovieDao
import com.sbs.data.movie.datasource.MovieDataSource
import com.sbs.data.movie.datasource.local.LocalMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(dao: MovieDao): MovieDataSource {
        return LocalMovieDataSource(dao)
    }
}













