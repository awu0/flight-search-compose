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
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(val flightList: List<Airport> = listOf())


class HomeViewModel(airportRepository: AirportRepository) : ViewModel() {

    val searchQueryFlow = MutableStateFlow("")

    private val allAirportsFlow: StateFlow<List<Airport>> = airportRepository.getAllAirports()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = listOf()
        )

    val homeUiState: StateFlow<HomeUiState> = searchQueryFlow
        .combine(allAirportsFlow) { query, airports ->
            // Filter the list based on the search query
            val filteredAirports = if (query.isBlank()) {
                airports
            } else {
                airports.filter { it.name.contains(query, ignoreCase = true) }
            }
            HomeUiState(filteredAirports)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    fun updateSearchQuery(query: String) {
        searchQueryFlow.value = query
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}