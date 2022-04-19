package com.kennedymenezes.marveluniverse.dashboard.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kennedymenezes.marveluniverse.dashboard.data.model.CharactersResultResponse
import com.kennedymenezes.marveluniverse.dashboard.data.model.MarvelResponse
import com.kennedymenezes.marveluniverse.dashboard.domain.repository.MarvelCharactersRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: MarvelCharactersRepository
) : ViewModel() {

    private var offset = 0

    private val _charactersList = MutableLiveData<List<CharactersResultResponse>>()
    val charactersList: LiveData<List<CharactersResultResponse>> = _charactersList

    private val _charactersHighlightList = MutableLiveData<List<CharactersResultResponse>>()
    val charactersHighlightList: LiveData<List<CharactersResultResponse>> = _charactersHighlightList

    fun getCharacters(connection: Boolean){
        viewModelScope.launch {
            _charactersList.value = repository.getCharacters(offset, connection)
        }
    }

    fun getHighLightCharacters(connection: Boolean){
        viewModelScope.launch {
            _charactersHighlightList.value = repository.getCharacters(1020, connection)
        }
    }

    fun loadMoreCharacters(connection: Boolean){
        offset += 20
        getCharacters(connection)
    }
}