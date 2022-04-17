package com.kennedymenezes.marveluniverse.commons.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kennedymenezes.marveluniverse.dashboard.data.model.CharactersResultResponse

@Dao
interface CharacterDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun setCharacters(list: List<CharactersResultResponse>)

    @Query("SELECT * FROM characters_table")
    fun getCharacters(): List<CharactersResultResponse>
}