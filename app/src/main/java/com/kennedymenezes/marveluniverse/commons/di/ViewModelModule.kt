package com.kennedymenezes.marveluniverse.commons.di

import com.kennedymenezes.marveluniverse.dashboard.ui.viewModel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get()) }
}