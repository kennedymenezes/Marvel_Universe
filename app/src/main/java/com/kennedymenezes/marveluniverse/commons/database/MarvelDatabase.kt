package com.kennedymenezes.marveluniverse.commons.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kennedymenezes.marveluniverse.commons.database.DAO.CharacterDAO
import com.kennedymenezes.marveluniverse.commons.database.converters.HeroImageConverter
import com.kennedymenezes.marveluniverse.dashboard.data.model.CharactersResultResponse

@Database(entities = [CharactersResultResponse::class], version = 1)
@TypeConverters(HeroImageConverter::class)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun getCharactersDAO() : CharacterDAO

    companion object {
        fun getDatabase(context: Context): MarvelDatabase {
            return Room.databaseBuilder(
                context,
                MarvelDatabase::class.java, "marvel_database"
            ).build()
        }
    }
}