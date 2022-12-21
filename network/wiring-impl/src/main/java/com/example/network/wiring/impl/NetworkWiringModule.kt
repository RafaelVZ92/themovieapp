package com.example.network.wiring.impl

import com.example.network.api.BaseUrlRepository
import com.example.network.api.MovieAppApi
import com.example.network.api.createOkHttpBuilder
import com.example.network.api.createRetrofitBuilder
import com.example.network.impl.repositories.BaseUrlRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

@Module
class NetworkWiringModule {
    
    @Provides
    @Reusable
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun providesAppBaseUrlRepository(): BaseUrlRepository = BaseUrlRepositoryImpl()

    @MovieAppApi
    @Provides
    @Singleton
    fun provideAppNewApiOkHttpClient(): OkHttpClient =
        createOkHttpBuilder(
            arrayListOf(
                loggingInterceptor
            )
        ).build()


    @MovieAppApi
    @Provides
    @Singleton
    fun provideAppPayNewApiRetrofit(
        @MovieAppApi httpClient: OkHttpClient,
        gson: Gson,
        baseUrlRepository: BaseUrlRepository
    ): Retrofit = createRetrofitBuilder(
        httpClient,
        baseUrlRepository.getUrlBase(),
        gson
    ).build()
}
