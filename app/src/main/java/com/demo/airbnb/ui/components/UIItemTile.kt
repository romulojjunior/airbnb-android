package com.demo.airbnb.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun UIItemTale(
    title: String = "",
    description: String = "",
    iconContent: @Composable (() -> Unit)? = null
) {
    Surface {
        Row(verticalAlignment = Alignment.CenterVertically ,modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            iconContent?.let {
                Surface(modifier = Modifier.padding( start = 8.dp , end = 16.dp)) {
                    it()
                }
            }
            Column {
                Text(text = title, style = MaterialTheme.typography.titleSmall)
                Text(text = description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun UIDetailsTailPreview() {
    AirbnbTheme {
        UIItemTale(
            title = "Tile tile",
            description = "Tile description",
            iconContent = {
                Icon(painter = painterResource(id = R.drawable.ic_bed), contentDescription = "" )
            }
        )
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UIDetailsTailNightPreview() {
    AirbnbTheme {
        UIItemTale(
            title = "Tile tile",
            description = "Tile description",
            iconContent = {
                Icon(painter = painterResource(id = R.drawable.ic_bed), contentDescription = "" )
            }
        )
    }
}