package com.example.movieapp.data.datasourceImpl

import com.example.movieapp.data.model.MovieList
import com.example.movieapp.data.api.TMDBService
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)


}