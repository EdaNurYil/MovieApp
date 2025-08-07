package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.domain.usecases.GetMoviesUseCases
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase

class ViewModelFactory(private val getMoviesUseCase: GetMoviesUseCases, private val updateMoviesUseCase: UpdateMoviesUseCase)
    : ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T{
            return com.example.movieapp.presentation.MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
        }

}