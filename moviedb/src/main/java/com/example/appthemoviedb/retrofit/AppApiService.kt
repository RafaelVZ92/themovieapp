package com.example.appthemoviedb.retrofit

import com.example.appthemoviedb.data.api.ResponseMovies
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApiService {

    @GET("movie/{movie_id}/lists")
    fun getMovies(
        @Path("movie_id") id: String = MOVIE_ID,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
        @Query("page") page: String = DEFAULT_PAGE,
    ) : Single<ResponseMovies>

    private companion object {
        const val LANGUAGE = "en-US"
        const val MOVIE_ID = "550"
        const val DEFAULT_PAGE = "1"
        const val API_KEY = "9a7813ff2dbeae953a032a0f600c06df"
    }
}