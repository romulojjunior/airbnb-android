package com.demo.airbnb.ui.features.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.airbnb.ui.features.explore.ExploreScreen
import com.demo.airbnb.ui.features.home.components.HomeNavigationBar
import com.demo.airbnb.ui.features.trips.TripsScreen
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun HomeScreen() {
    var tabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            HomeNavigationBar(
                tabIndex = tabIndex,
                onTabSelected = { index -> tabIndex = index }
            )
        }
    ) { scaffoldPadding ->
        when (tabIndex) {
            0 -> {
                Surface(modifier = Modifier.padding(paddingValues = scaffoldPadding)) {
                    ExploreScreen()
                }
            }
            else -> {
                Surface(modifier = Modifier.padding(paddingValues = scaffoldPadding)) {
                    TripsScreen()
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun HomeScreenPreview() {
    AirbnbTheme {
        HomeScreen()
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun HomeScreenNightPreview() {
    AirbnbTheme {
        HomeScreen()
    }
}