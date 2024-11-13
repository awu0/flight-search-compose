package com.awu0.flightsearch.data

import android.content.Context

/**
 * App container for dependency injection.
 */
interface AppContainer {
    val airportRepository: AirportRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val airportRepository: AirportRepository by lazy {
        OfflineAirportRepository(AirportDatabase.getDatabase(context).airportDao())
    }
}