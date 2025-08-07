package com.example.movieapp.data.datasourceImpl

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.model.Movie

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
     return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)

    }
}