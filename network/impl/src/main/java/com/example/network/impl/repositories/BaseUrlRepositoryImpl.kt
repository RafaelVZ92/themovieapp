package com.example.network.impl.repositories

import com.example.network.api.BaseUrlRepository
import com.example.network.api.model.TheMovieUrlConfig
import com.example.network.impl.UrlConstants
import javax.inject.Inject

class BaseUrlRepositoryImpl @Inject constructor() : BaseUrlRepository {

    private val theMovieUrlConfig = TheMovieUrlConfig(
        themoviedbUrl = UrlConstants.MOVIES_URL
    )


    override fun getUrlBase(): String = theMovieUrlConfig.themoviedbUrl

}