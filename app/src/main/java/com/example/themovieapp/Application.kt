package com.example.themovieapp

import com.example.themovieapp.di.BaseComponent


abstract class Application : InjectableApplication() {

    var component: BaseComponent? = null
        protected set

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: Application? = null
            private set
    }
}
