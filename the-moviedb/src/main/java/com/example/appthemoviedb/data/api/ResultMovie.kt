package com.example.appthemoviedb.data.api

data class ResultMovie(
    val description: String,
    val favorite_count: Int,
    val id: Int,
    val iso_639_1: String,
    val item_count: Int,
    val list_type: String,
    val name: String,
    val poster_path: String
)