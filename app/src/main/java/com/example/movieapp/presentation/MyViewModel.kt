package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.usecases.GetMoviesUseCases
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCases,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData<List<Movie>?> {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData<List<Movie>?> {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}
