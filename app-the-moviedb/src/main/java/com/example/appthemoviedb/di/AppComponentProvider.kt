package com.example.appthemoviedb.di

import com.example.appthemoviedb.di.components.AppComponent


interface AppComponentProvider {
    fun provideAppComponent(): AppComponent
}