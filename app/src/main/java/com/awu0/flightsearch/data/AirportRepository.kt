package com.awu0.flightsearch.data

import com.awu0.flightsearch.model.Airport
import kotlinx.coroutines.flow.Flow

interface AirportRepository {
    fun getAllAirports(): Flow<List<Airport>>

    fun getAirport(id: Int): Flow<Airport?>
}