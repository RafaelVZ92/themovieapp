package com.example.appthemoviedb.actions

import com.example.appthemoviedb.data.api.ResponseMovies


sealed class TheMovieAction {
    data class Success(
        val response: ResponseMovies
    ): TheMovieAction()
}
