package com.awu0.flightsearch.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {

    @Query("SELECT * FROM airport")
    fun getAllAirports(): Flow<List<Airport>>

    @Query("SELECT * FROM airport WHERE id = :id")
    fun getAirport(id: Int): Flow<Airport>
}