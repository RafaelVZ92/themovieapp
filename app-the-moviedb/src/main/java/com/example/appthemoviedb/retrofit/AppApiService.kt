package com.example.appthemoviedb.retrofit

import com.example.appthemoviedb.data.api.ResponseMovies
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApiService {

    @GET("movie/{movie_id}/list")
    fun getMovies(
        @Path("movie_id") id: String = MOVIE_ID,
        @Query("api_key") apiKey: String = API_KEY
    ) : Single<ResponseMovies>

    private companion object {
        const val MOVIE_ID = "1"
        const val API_KEY = "08425cd314576d2ad6072d596f49b16c"
    }
}