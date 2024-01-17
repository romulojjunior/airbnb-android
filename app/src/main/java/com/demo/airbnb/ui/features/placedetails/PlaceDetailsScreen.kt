package com.demo.airbnb.ui.features.placedetails

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.ui.components.UILoading
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun PlaceDetailsScreen(
    uiState: MutableState<PlaceDetailsVM.UIState> = mutableStateOf(PlaceDetailsVM.UIState()),
    placeId: Int,
    onBack: () -> Unit = {},
    fetchPlace: (id: Int) -> Unit = { _ -> },
) {

    LaunchedEffect(key1 = placeId, block = {
        fetchPlace(placeId)
    })

    if (uiState.value.isLoading) {
        UILoading()
        return
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Box(modifier = Modifier.padding(bottom = 32.dp)) {
                Text(
                    "Place details",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun PlaceDetailsScreenPreview() {
    AirbnbTheme {
        PlaceDetailsScreen(placeId = 1)
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun PlaceDetailsScreenNightPreview() {
    AirbnbTheme {
        PlaceDetailsScreen(placeId = 1)
    }
}