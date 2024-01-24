package com.demo.airbnb.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.demo.airbnb.AppConfig
import com.demo.airbnb.R
import com.demo.airbnb.domain.entities.Place
import com.demo.airbnb.domain.utils.NumberFormatUtils
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun PlaceCard(place: Place, onClick: (place: Place) -> Any = {}) {
    Column(modifier = Modifier.clickable { onClick(place) }) {
        Card(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = place.coverUrl,
                    contentDescription = "Place image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                    placeholder = painterResource(id = R.drawable.connection_error),
                    error = painterResource(id = R.drawable.connection_error)
                )
                val locale = LocalContext.current.resources.configuration.locales[0]
                Text(text = NumberFormatUtils.formatCurrency(locale, place.price), color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(8.dp).align(Alignment.BottomEnd))
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier= Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)) {

            Text(place.address, overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.titleMedium)

            Row {
                Icon(Icons.Filled.Star, contentDescription = "Average of stars", modifier = Modifier.padding(horizontal = 8.dp))
                Text("${place.starts}", overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.titleMedium)
            }
        }

        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp)) {
            Text(place.description, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun PlaceCardLightPreview() {
    val place = Place(
        id = 1,
        name = "Place name",
        description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more",
        address = "San Petter, Hannoia, AK",
        price = 150.00,
        coverUrl = "${AppConfig.hostUrl}/assets/001/001.webp",
        imagesUrl = listOf(
            "${AppConfig.hostUrl}/assets/001/001.webp",
            "${AppConfig.hostUrl}/assets/001/002.webp",
            "${AppConfig.hostUrl}/assets/001/003.webp",
            "${AppConfig.hostUrl}/assets/001/004.webp",
        )
    )
    AirbnbTheme {
        PlaceCard(place = place)
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun PlaceCardNightPreview() {
    val place = Place(
        id = 1,
        name = "Place name",
        description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more",
        address = "San Petter, Hannoia, AK",
        price = 150.00,
        coverUrl = "${AppConfig.hostUrl}/assets/001/001.webp",
        imagesUrl = listOf(
            "${AppConfig.hostUrl}/assets/001/001.webp",
            "${AppConfig.hostUrl}/assets/001/002.webp",
            "${AppConfig.hostUrl}/assets/001/003.webp",
            "${AppConfig.hostUrl}/assets/001/004.webp",
        )
    )
    AirbnbTheme {
        PlaceCard(place = place)
    }
}
