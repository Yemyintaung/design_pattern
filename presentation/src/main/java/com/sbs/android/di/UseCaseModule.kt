package com.sbs.android.di

import com.sbs.domain.movie.repository.MovieRepository
import com.sbs.domain.movie.usecase.GetMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetMoviesUseCase(
        movieRepository: MovieRepository
    ): GetMovie {
        return GetMovie(movieRepository)
    }
}