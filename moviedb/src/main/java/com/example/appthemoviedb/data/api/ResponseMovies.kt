package com.example.appthemoviedb.data.api

data class ResponseMovies(
    val id: Int,
    val page: Int,
    val results: List<ResultMovie>,
    val total_pages: Int,
    val total_results: Int
)