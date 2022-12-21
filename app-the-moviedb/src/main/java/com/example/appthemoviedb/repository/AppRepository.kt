package com.example.appthemoviedb.repository

import com.example.appthemoviedb.data.api.ResponseMovies
import com.example.appthemoviedb.retrofit.AppApiService
import dagger.Reusable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//TODO private val apiService: AppApiService pending
@Reusable
class AppRepository @Inject constructor(

) {

  /*  fun getMovies(id: String): Single<ResponseMovies>{
        return apiService.getMovies(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }*/
}