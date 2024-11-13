package com.awu0.flightsearch.data

import com.awu0.flightsearch.model.Flight
import kotlinx.coroutines.flow.Flow

interface FlightRepository {
    fun getAllFlights(): Flow<List<Flight>>

    fun getFlight(id: Int): Flow<Flight?>
}