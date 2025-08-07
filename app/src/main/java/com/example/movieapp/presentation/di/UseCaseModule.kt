package com.example.movieapp.presentation.di

import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.usecases.GetMoviesUseCases
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCases {
        return GetMoviesUseCases(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

}