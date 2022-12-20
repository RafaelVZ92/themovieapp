package com.example.themovieapp.di.modules

import com.example.themovieapp.scopes.ActivityScope
import com.example.themovieapp.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity
}