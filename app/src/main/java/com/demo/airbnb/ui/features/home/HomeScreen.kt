package com.demo.airbnb.ui.features.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.airbnb.R
import com.demo.airbnb.ui.components.UIHeader
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun HomeScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            UIHeader(R.string.homescreen_title)
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
    showBackground = true,
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun HomeScreenNightPreview() {
    AirbnbTheme {
        HomeScreen()
    }
}