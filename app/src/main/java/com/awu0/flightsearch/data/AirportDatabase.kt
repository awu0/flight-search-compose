package com.awu0.flightsearch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.awu0.flightsearch.model.Airport
import com.awu0.flightsearch.model.AirportDao

@Database(entities = [Airport::class], version = 1, exportSchema = false)
abstract class AirportDatabase : RoomDatabase() {

    abstract fun airportDao(): AirportDao

    companion object {
        @Volatile
        private var Instance: AirportDatabase? = null

        fun getDatabase(context: Context): AirportDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AirportDatabase::class.java, "airport_database")
                    .createFromAsset("database/flight_search.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}