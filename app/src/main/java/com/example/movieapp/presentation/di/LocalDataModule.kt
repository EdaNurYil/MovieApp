package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasourceImpl.MovieLocalDataSourceImpl
import com.example.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module //it will provide dependencies to inject into other classes
class LocalDataModule {
    @Singleton // it tels dagger to create only one instance of this dependency
    @Provides //marks a function that return a dependency

    fun provideMovieLocalDataSource(movieDao: MovieDao) :MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)

    }
}