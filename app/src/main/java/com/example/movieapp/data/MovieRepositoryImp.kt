package com.example.movieapp.data

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.repository.MovieRepository

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movie
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        return movieList
    }

    private suspend fun getMoviesFromROOM(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return if (movieList.isNotEmpty()) {
            movieList
        } else {
            val newList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(newList)
            newList
        }
    }
}
