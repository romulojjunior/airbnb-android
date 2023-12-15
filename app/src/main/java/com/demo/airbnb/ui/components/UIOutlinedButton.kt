package com.demo.airbnb.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun UIOutlinedButton(
    label: String,
    iconPainter: Painter,
    tint: Color = MaterialTheme.colorScheme.primary,
    contentDescription: String = "",
    onClick: () -> Unit
) {
    OutlinedButton(
        contentPadding = PaddingValues(vertical = 16.dp),
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = contentDescription,
                tint = tint
            )
            Text(
                text = label,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun UIOutlinedButtonPreview() {
    AirbnbTheme {
        UIOutlinedButton(
            label = stringResource(id = R.string.ui_sample),
            iconPainter = painterResource(id = R.drawable.outline_email_24),
            onClick = {}
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun UIOutlinedButtonNightPreview() {
    AirbnbTheme {
        UIOutlinedButton(
            label = stringResource(id = R.string.ui_sample),
            iconPainter = painterResource(id = R.drawable.outline_email_24),
            onClick = {}
        )
    }
}