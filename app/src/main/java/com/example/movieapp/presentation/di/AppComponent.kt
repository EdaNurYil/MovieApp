package com.example.movieapp.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    LocalDataModule::class

])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
}