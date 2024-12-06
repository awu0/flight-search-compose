package com.awu0.flightsearch.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.awu0.flightsearch.model.Airport
import com.awu0.flightsearch.ui.AppViewModelProvider

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val homeUiState by viewModel.homeUiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        OutlinedTextField(
            value = viewModel.searchQueryFlow.collectAsState().value,
            onValueChange = { viewModel.updateSearchQuery(it) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text("Search")
            },
            shape = RoundedCornerShape(64.dp),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        AirportList(homeUiState.flightList)
    }
}


@Composable
fun AirportList(
    airportList: List<Airport>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = airportList, key = {it.id}) {item ->
            Text(
                text=item.name,
                fontSize = 24.sp
            )
        }
    }
}