package com.kennedymenezes.marveluniverse.dashboard.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kennedymenezes.marveluniverse.dashboard.domain.repository.MarvelCharactersRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: MarvelCharactersRepository
) : ViewModel() {

    fun getCharacters(){
        viewModelScope.launch {
            val aux = repository.getCharacters()
            println(aux)
        }
    }
}