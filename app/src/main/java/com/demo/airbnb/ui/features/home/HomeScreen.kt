package com.demo.airbnb.ui.features.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.demo.airbnb.data.samples.PlaceCategorySample
import com.demo.airbnb.domain.entities.Place
import com.demo.airbnb.ui.AppRouter
import com.demo.airbnb.ui.components.UILoading
import com.demo.airbnb.ui.features.explore.ExploreScreen
import com.demo.airbnb.ui.features.home.components.HomeNavigationBar
import com.demo.airbnb.ui.features.trips.TripsScreen
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun HomeScreen(
    viewModel: HomeVM = hiltViewModel<HomeVM>(),
    navController: NavController,
) {
    val state by viewModel.uiState.collectAsState()

    HomeScreenContent(
        uiState = state,
        navigateToPlaceDetails =  {
            navController.navigate(AppRouter.placeDetailsPath(it.id))
        }
    )
}

@Composable
fun HomeScreenContent(
    uiState: HomeVM.UIState = HomeVM.UIState(),
    navigateToPlaceDetails: (place: Place) -> Any = {}
) {
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

        if (uiState.isLoading) {
            UILoading()
        } else {
            when (tabIndex) {
                0 -> {
                    Surface(modifier = Modifier.padding(paddingValues = scaffoldPadding)) {
                        ExploreScreen(
                            placeCategories = uiState.placeCategories,
                            navigateToPlaceDetails = navigateToPlaceDetails
                        )
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
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun HomeScreenPreview() {
    AirbnbTheme {
        HomeScreenContent(
            uiState = HomeVM.UIState(
                placeCategories = PlaceCategorySample
            )
        )
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun HomeScreenNightPreview() {
    AirbnbTheme {
        HomeScreenContent(
            uiState = HomeVM.UIState(
                placeCategories = PlaceCategorySample
            )
        )
    }
}