package com.awu0.flightsearch.data

import com.awu0.flightsearch.model.Airport
import com.awu0.flightsearch.model.AirportDao
import kotlinx.coroutines.flow.Flow

class OfflineAirportRepository(private val airportDao: AirportDao): AirportRepository {
    override fun getAllAirports(): Flow<List<Airport>> = airportDao.getAllAirports()

    override fun getAirport(id: Int): Flow<Airport?> = airportDao.getAirport(id)
}