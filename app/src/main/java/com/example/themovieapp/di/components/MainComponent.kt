package com.example.themovieapp.di.components

import com.example.appthemoviedb.di.components.AppComponent
import com.example.themovieapp.InjectableApplication
import com.example.themovieapp.di.BaseComponent
import com.example.themovieapp.di.modules.ActivityBuilder
import com.example.themovieapp.di.modules.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainModule::class,
        ActivityBuilder::class
    ]
)
interface MainComponent:
    BaseComponent,
    AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): MainComponent

        @BindsInstance
        fun application(application: InjectableApplication): Builder
    }
}
