package com.kennedymenezes.marveluniverse.dashboard.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kennedymenezes.marveluniverse.dashboard.data.model.MarvelResponse
import com.kennedymenezes.marveluniverse.dashboard.domain.repository.MarvelCharactersRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: MarvelCharactersRepository
) : ViewModel() {

    private val _charactersList = MutableLiveData<MarvelResponse>()
    val charactersList: LiveData<MarvelResponse> = _charactersList

    fun getCharacters(){
        viewModelScope.launch {
            _charactersList.value = repository.getCharacters()
        }
    }
}