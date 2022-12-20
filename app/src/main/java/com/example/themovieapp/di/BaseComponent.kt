package com.example.themovieapp.di

import android.app.Application
import android.content.Context
import com.example.themovieapp.InjectableApplication
import dagger.android.AndroidInjector


interface BaseComponent : AndroidInjector<InjectableApplication> {

    fun context(): Context

    fun application(): Application

}
