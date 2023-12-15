package com.demo.airbnb.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun UIHeader(label: String) {
    Text(
        text = label,
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
    val label = "Header"
    AirbnbTheme {
        UIHeader(label)
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UIHeaderNightPreview() {
    val label = "Header"
    AirbnbTheme {
        UIHeader(label)
    }
}