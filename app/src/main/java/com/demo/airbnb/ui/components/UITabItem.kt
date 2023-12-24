package com.demo.airbnb.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun UITabItem(
    label: String,
    imageVector: ImageVector,
    contentDescription: String?,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Tab(
        selected = selected,
        onClick = onClick,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(imageVector, contentDescription = contentDescription)
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun UITabItemLightPreview() {
    AirbnbTheme {
        UITabItem(
            label = stringResource(id = R.string.ui_sample),
            imageVector = Icons.Filled.Home,
            contentDescription = "Content Preview",
            selected = true,
            onClick = {},
            )
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UITabItemNightPreview() {
    AirbnbTheme {
        UITabItem(
            label = stringResource(id = R.string.ui_sample),
            imageVector = Icons.Filled.Home,
            contentDescription = "Content Preview",
            selected = true,
            onClick = {},
        )
    }
}