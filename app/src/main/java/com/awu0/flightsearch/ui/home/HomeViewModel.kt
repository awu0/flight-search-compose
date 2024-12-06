package com.awu0.flightsearch.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awu0.flightsearch.data.AirportRepository
import com.awu0.flightsearch.model.Airport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(val flightList: List<Airport> = listOf())


class HomeViewModel(airportRepository: AirportRepository): ViewModel() {

    var searchQuery by mutableStateOf("")
        private set

    val homeUiState: StateFlow<HomeUiState> =
        airportRepository.getAllAirports().map {HomeUiState(it)}
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}