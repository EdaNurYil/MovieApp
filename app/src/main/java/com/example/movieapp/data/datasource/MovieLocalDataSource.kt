package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.Movie

interface MovieLocalDataSource {

    //get movies from the database
    suspend fun getMoviesFromDB(): List<Movie>

    //save movies to the database
    suspend fun saveMoviesToDB(movies: List<Movie>)

    //clear all the movies
    suspend fun clearAll()
}