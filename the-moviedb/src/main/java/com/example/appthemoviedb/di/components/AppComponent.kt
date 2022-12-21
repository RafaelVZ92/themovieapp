package com.example.appthemoviedb.di.components

import android.app.Application
import android.content.Context
import com.example.network.api.MovieAppApi
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface AppComponent {

    fun context(): Context

    fun application(): Application

    fun gson(): Gson

    @MovieAppApi
    fun providesAppRetrofit(): Retrofit

    @MovieAppApi
    fun providesAppOkHttpClient(): OkHttpClient
}