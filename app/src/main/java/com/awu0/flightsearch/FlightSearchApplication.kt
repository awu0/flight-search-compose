package com.awu0.flightsearch

import android.app.Application
import com.awu0.flightsearch.data.AppContainer
import com.awu0.flightsearch.data.AppDataContainer

class FlightSearchApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}