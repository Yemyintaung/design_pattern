package com.sbs.android.di

import com.sbs.data.movie.factory.MovieFactory
import com.sbs.data.movie.repository.MovieRepositoryImpl
import com.sbs.domain.movie.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(
        factory: MovieFactory
    ): MovieRepository {
        return MovieRepositoryImpl(
            factory
        )
    }
}














