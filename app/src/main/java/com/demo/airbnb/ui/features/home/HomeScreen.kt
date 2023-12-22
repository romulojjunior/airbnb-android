package com.demo.airbnb.ui.features.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.components.UIHeader
import com.demo.airbnb.ui.features.home.components.HomeNavigationBar
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
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
        ) {
            LazyColumn(Modifier.padding(horizontal = 16.dp)) {
                item {
                    UIHeader(stringResource(R.string.homescreen_title))
                }

                (1..50).toList().forEach {
                    item {
                        Surface(
                            modifier = Modifier
                                .height(200.dp)
                                .padding(vertical = 8.dp)
                                .fillMaxWidth(), color = Color.LightGray
                        ) {}
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