package com.awu0.flightsearch.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {

    @Query("SELECT * FROM airport")
    fun getAllFlights(): Flow<List<Flight>>

    @Query("SELECT * FROM airport WHERE id = :id")
    fun getFlight(id: Int): Flow<Flight>
}