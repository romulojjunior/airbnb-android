package com.demo.airbnb.ui.components

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun UIHeader(@StringRes labelID: Int) {
    Text(
        text = stringResource(id = labelID),
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun UIHeaderPreview() {
    AirbnbTheme {
        UIHeader(R.string.homescreen_title)
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UIHeaderNightPreview() {
    AirbnbTheme {
        UIHeader(R.string.homescreen_title)
    }
}