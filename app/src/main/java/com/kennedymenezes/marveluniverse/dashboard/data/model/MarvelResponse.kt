package com.kennedymenezes.marveluniverse.dashboard.data.model

import com.google.gson.annotations.SerializedName

data class MarvelResponse(
    @SerializedName("data")
    val data: MarvelCharactersResponse
)

data class MarvelCharactersResponse(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("results")
    val heroesResult: List<CharactersResultResponse>
)

data class CharactersResultResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val heroImage: HeroImage
)

data class HeroImage(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
)
