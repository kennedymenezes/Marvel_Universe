package com.kennedymenezes.marveluniverse.commons.di

import com.kennedymenezes.marveluniverse.commons.database.MarvelDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        MarvelDatabase.getDatabase(androidApplication()).getCharactersDAO()
    }
}