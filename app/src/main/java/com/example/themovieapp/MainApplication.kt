package com.example.themovieapp

import com.example.appthemoviedb.di.AppComponentProvider
import com.example.themovieapp.di.components.DaggerMainComponent
import com.example.themovieapp.di.components.MainComponent


class MainApplication :
    Application(),
    AppComponentProvider {

    companion object {
        lateinit var instance: MainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun initializeInjector() {
        val component = DaggerMainComponent.builder()
            .application(this)
            .build()
            .apply { inject(this@MainApplication) }
        this.component = component
    }

    private fun getMainComponent() = component as MainComponent

    override fun provideAppComponent() = getMainComponent()
}