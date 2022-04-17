package com.kennedymenezes.marveluniverse.commons.di

import com.kennedymenezes.marveluniverse.dashboard.domain.repository.MarvelCharactersRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { MarvelCharactersRepository(get(), get()) }
}