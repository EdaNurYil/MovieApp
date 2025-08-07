package com.example.movieapp.presentation.di

import com.example.movieapp.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {


    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
    fun inject(movieActivity: MainActivity)
}