package com.example.appthemoviedb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appthemoviedb.actions.TheMovieAction
import com.example.appthemoviedb.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MovieDBViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val action = MutableLiveData<TheMovieAction>()

    fun getTvShow() {
        disposable.add(
            repository.getMovies("550")
                .subscribe(
                    {
                        action.value = TheMovieAction.Success(it)
                    },
                    {
                        println(it.message)
                    }
                )
        )
    }
}