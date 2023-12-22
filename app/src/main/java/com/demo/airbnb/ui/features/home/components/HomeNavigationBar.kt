package com.demo.airbnb.ui.features.home.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun HomeNavigationBar(
    tabIndex: Int,
    onTabSelected: (index: Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_explore))
            },
            selected = tabIndex == 0,

            onClick = {
                onTabSelected(0)
            }, icon = {
                Icon(Icons.Filled.Search, contentDescription = "Localized description")
            })
        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_favorites))
            },
            selected = tabIndex == 1,
            onClick = { onTabSelected(1)},
            icon = {
                Icon(
                    Icons.Filled.FavoriteBorder,
                    contentDescription = "Localized description"
                )
            })
        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_trips))
            },
            selected = tabIndex == 2,
            onClick = { onTabSelected(2)},
            icon = {
                Icon(Icons.Filled.DateRange, contentDescription = "Localized description")
            })
        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_messages))
            },
            selected = tabIndex == 3,
            onClick = { onTabSelected(3) },
            icon = {
                Icon(Icons.Filled.Email, contentDescription = "Localized description")
            })
        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.nav_profile))
            },
            selected = tabIndex == 4,
            onClick = { onTabSelected(4) },
            icon = {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Localized description")
            })
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun HomeNavigationBarPreview() {
    AirbnbTheme {
        HomeNavigationBar(tabIndex = 0, onTabSelected = {})
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun HomeNavigationBarNightPreview() {
    AirbnbTheme {
        HomeNavigationBar(tabIndex = 0, onTabSelected = {})
    }
}