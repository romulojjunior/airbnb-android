package com.demo.airbnb.ui.features.placedetails.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun PlaceDetailsScoreReview(
    rate: Double = 0.0,
    reviews: Long = 0
) {

    OutlinedCard(modifier = Modifier.height(90.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text =  "$rate", style = MaterialTheme.typography.titleMedium)
                Text(text =  "Starts", style = MaterialTheme.typography.bodySmall)
            }

            Divider(modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(R.string.guest), style = MaterialTheme.typography.titleMedium)
                Text(text = stringResource(R.string.favorite), style = MaterialTheme.typography.titleMedium)
            }

            Divider(modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text =  "$reviews", style = MaterialTheme.typography.titleMedium)
                Text(text =  "Reviews", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun PlaceDetailsScoreReviewPreview() {
    AirbnbTheme {
        PlaceDetailsScoreReview()
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun PlaceDetailsScoreReviewNightPreview() {
    AirbnbTheme {
        PlaceDetailsScoreReview()
    }
}