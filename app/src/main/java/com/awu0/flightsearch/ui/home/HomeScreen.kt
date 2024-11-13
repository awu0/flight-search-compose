package com.awu0.flightsearch.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.awu0.flightsearch.model.Airport
import com.awu0.flightsearch.ui.AppViewModelProvider

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val homeUiState by viewModel.homeUiState.collectAsState()

    AirportList(homeUiState.flightList)
}


@Composable
fun AirportList(
    airportList: List<Airport>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = airportList, key = {it.id}) {item ->
            Text(item.name)
        }
    }
}