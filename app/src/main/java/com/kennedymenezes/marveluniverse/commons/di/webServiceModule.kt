package com.kennedymenezes.marveluniverse.commons.di

import com.kennedymenezes.marveluniverse.dashboard.data.api.IMarvelWebService
import com.kennedymenezes.marveluniverse.dashboard.data.api.MarvelWebServiceImp
import org.koin.dsl.module

val webServiceModule = module {
    factory<IMarvelWebService> { MarvelWebServiceImp() }
}