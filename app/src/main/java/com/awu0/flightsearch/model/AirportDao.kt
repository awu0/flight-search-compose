package com.awu0.flightsearch.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {

    @Query("SELECT * FROM airports")
    fun getAllFlights(): Flow<List<Airport>>

    @Query("SELECT * FROM airports WHERE id = :id")
    fun getFlight(id: Int): Flow<Airport>
}