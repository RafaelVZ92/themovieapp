package com.example.appthemoviedb.di.components

import android.app.Application
import android.content.Context
import com.google.gson.Gson

interface AppComponent {

    fun context(): Context

    fun application(): Application

/*
    fun gson(): Gson

    @AppApi
    fun providesAppRetrofit(): Retrofit

    @AppApi
    fun providesAppOkHttpClient(): OkHttpClient*/
}