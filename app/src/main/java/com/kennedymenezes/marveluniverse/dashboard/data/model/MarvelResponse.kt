package com.kennedymenezes.marveluniverse.dashboard.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
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

@Entity(tableName = "characters_table")
data class CharactersResultResponse(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val heroImage: HeroImage
) {
    fun getHeroImg(): String {
        return "${heroImage.path}.${heroImage.extension}"
    }
}

data class HeroImage(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
)
