package com.example.appthemoviedb.di.modules

import com.example.appthemoviedb.retrofit.AppApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

//TODO The Api is missing
@Module
class ApiServiceModule {

    @Provides
    @Reusable
    fun provideAppApiService(retrofit: Retrofit): AppApiService =
        retrofit.create(AppApiService::class.java)
}