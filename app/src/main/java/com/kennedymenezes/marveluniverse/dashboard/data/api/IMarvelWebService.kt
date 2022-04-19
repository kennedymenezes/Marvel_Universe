package com.kennedymenezes.marveluniverse.dashboard.data.api

import com.kennedymenezes.marveluniverse.dashboard.data.model.MarvelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarvelWebService {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): Response<MarvelResponse>
}