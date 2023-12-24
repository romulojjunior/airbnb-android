package com.demo.airbnb.ui.features.trips

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.airbnb.ui.components.UIHeader
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun TripsScreen() {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            UIHeader(label = "Trips")
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun TripsScreenLightPreview() {
    AirbnbTheme {
        TripsScreen()
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun TripsScreenNightPreview() {
    AirbnbTheme {
        TripsScreen()
    }
}