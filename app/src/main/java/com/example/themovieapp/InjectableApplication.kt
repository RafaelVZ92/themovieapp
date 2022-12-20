package com.example.themovieapp

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class InjectableApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = androidInjector


    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    abstract fun initializeInjector()
}
