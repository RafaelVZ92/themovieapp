package com.example.appthemoviedb.di.components

import androidx.fragment.app.FragmentActivity
import com.example.appthemoviedb.di.AppComponentProvider
import com.example.appthemoviedb.di.modules.ApiServiceModule
import dagger.Component
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//TODO ApiServiceModule::class pending
@Singleton
@Component(
    dependencies = [AppComponent::class],
    modules = [
        AndroidSupportInjectionModule::class
    ]
)
interface TheMovieComponent :
    ViewModelProvider {

    @Component.Factory
    interface Factory {
        fun create(
            parentProvider: AppComponent
        ): TheMovieComponent
    }

    fun androidInjector(): DispatchingAndroidInjector<Any>
}


val FragmentActivity.injector
    get() = DaggerTheMovieComponent.factory()
        .create((application as AppComponentProvider).provideAppComponent())

fun FragmentActivity.inject() {
    DaggerTheMovieComponent.factory()
        .create((application as AppComponentProvider).provideAppComponent())
        .androidInjector()
        .inject(this)
}
