package com.example.appthemoviedb.di.modules

import com.example.appthemoviedb.retrofit.AppApiService
import com.example.network.api.MovieAppApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class ApiServiceModule {

    @MovieAppApi
    @Provides
    @Reusable
    fun provideAppApiService(@MovieAppApi retrofit: Retrofit): AppApiService =
        retrofit.create(AppApiService::class.java)
}