package com.awu0.flightsearch.data

import com.awu0.flightsearch.model.Flight
import com.awu0.flightsearch.model.FlightDao
import kotlinx.coroutines.flow.Flow

class OfflineFlightRepository(private val flightDao: FlightDao): FlightRepository {
    override fun getAllFlights(): Flow<List<Flight>> = flightDao.getAllFlights()

    override fun getFlight(id: Int): Flow<Flight?> = flightDao.getFlight(id)
}