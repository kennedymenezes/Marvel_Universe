package com.kennedymenezes.marveluniverse.dashboard.data.api

import com.kennedymenezes.marveluniverse.dashboard.data.model.MarvelResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest

class MarvelWebServiceImp : IMarvelWebService {

    private val webservice = Retrofit.Builder()
        .baseUrl("http://gateway.marvel.com")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(IMarvelWebService::class.java)

    override suspend fun getCharacters(ts: String, apiKey: String, hash: String, offset: Int): Response<MarvelResponse> {
        return webservice.getCharacters(
            ts = ts,
            hash = hash,
            apiKey = apiKey,
            offset = offset
        )
    }
}