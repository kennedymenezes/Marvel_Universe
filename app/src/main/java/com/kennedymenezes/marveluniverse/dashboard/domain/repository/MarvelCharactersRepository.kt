package com.kennedymenezes.marveluniverse.dashboard.domain.repository

import com.kennedymenezes.marveluniverse.commons.database.DAO.CharacterDAO
import com.kennedymenezes.marveluniverse.dashboard.data.api.IMarvelWebService
import com.kennedymenezes.marveluniverse.dashboard.data.model.CharactersResultResponse
import com.kennedymenezes.marveluniverse.dashboard.data.model.MarvelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest

class MarvelCharactersRepository(
    private val webService: IMarvelWebService,
    private val charactersDAO: CharacterDAO
) {

    companion object {
        private const val PUBLIC_KEY = "c89ed43ea0f5f0f0de15a547f7ead608"
        private const val PRIVATE_KEY = "609478f76e078b9c27cbf845e13c139003d6130e"
    }

    suspend fun getCharacters(offset: Int, connection: Boolean): List<CharactersResultResponse> {
        if (connection) {
            return withContext(Dispatchers.Default) {
                checkResponse(
                    webService.getCharacters(
                        ts = "1",
                        hash = "84b0922491335afc18aa36f8ec2d38f2",
                        apiKey = PUBLIC_KEY,
                        offset = offset
                    )
                )
            }
        } else {
            return withContext(Dispatchers.Default){
                charactersDAO.getCharacters()
            }
        }
    }

private fun checkResponse(response: Response<MarvelResponse>): List<CharactersResultResponse> {
    if (response.body() != null) {
        charactersDAO.setCharacters(response.body()!!.data.heroesResult)
        return response.body()!!.data.heroesResult
    } else {
        throw Exception("Api offline")
    }
}

private fun generateHash(ts: String): String {
    val input = "${ts}${PUBLIC_KEY}${PRIVATE_KEY}"
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}
}