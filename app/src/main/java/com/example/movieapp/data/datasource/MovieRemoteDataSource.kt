package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    //suspend function can be pause and resume at a later time
    suspend fun getMovies() : Response<MovieList>
}