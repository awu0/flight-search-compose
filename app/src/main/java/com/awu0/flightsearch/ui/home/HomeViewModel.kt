package com.awu0.flightsearch.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awu0.flightsearch.data.AirportRepository
import com.awu0.flightsearch.model.Airport
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(val flightList: List<Airport> = listOf())


class HomeViewModel(airportRepository: AirportRepository): ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        airportRepository.getAllAirports().map {HomeUiState(it)}
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}