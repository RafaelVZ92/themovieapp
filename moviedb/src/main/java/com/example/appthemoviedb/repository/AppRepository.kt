package com.example.appthemoviedb.repository

import com.example.appthemoviedb.data.api.ResponseMovies
import com.example.appthemoviedb.retrofit.AppApiService
import com.example.network.api.MovieAppApi
import dagger.Reusable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@Reusable
class AppRepository @Inject constructor(
    @MovieAppApi private val apiService: AppApiService
) {

    fun getMovies(id: String): Single<ResponseMovies> {
        return apiService.getMovies(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}