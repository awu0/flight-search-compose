package com.awu0.flightsearch.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.awu0.flightsearch.ui.home.HomeScreen

@Composable
fun FlightSearchApp() {

    Scaffold(
    ) { contentPadding ->

        Surface(
            modifier = Modifier.fillMaxSize().padding(contentPadding)
        ) {
            HomeScreen()
        }
    }
}