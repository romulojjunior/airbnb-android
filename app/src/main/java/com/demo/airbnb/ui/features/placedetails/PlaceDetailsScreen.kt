package com.demo.airbnb.ui.features.placedetails

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.demo.airbnb.R
import com.demo.airbnb.domain.utils.NumberFormatUtils
import com.demo.airbnb.ui.components.UIError
import com.demo.airbnb.ui.components.UILoading
import com.demo.airbnb.ui.components.UIItemTale
import com.demo.airbnb.ui.features.placedetails.components.PlaceDetailsScoreReview
import com.demo.airbnb.ui.theme.AirbnbTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlaceDetailsScreen(
    uiState: MutableState<PlaceDetailsVM.UIState> = mutableStateOf(PlaceDetailsVM.UIState()),
    placeId: Int,
    onBack: () -> Unit = {},
    fetchPlace: (id: Int) -> Unit = { _ -> },
) {
    val pagerState = rememberPagerState(pageCount = { uiState.value.place?.imagesUrl?.size ?: 0 })

    LaunchedEffect(key1 = placeId, block = {
        fetchPlace(placeId)
    })

    if (uiState.value.isLoading) {
        UILoading()
        return
    }

    if (uiState.value.exception != null) {
        UIError(
            onRetry = {
                fetchPlace(placeId)
            }
        )
        return
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            uiState.value.place?.let { place ->

                item {
                    HorizontalPager(state = pagerState) { index ->
                        val url = place.imagesUrl[index]
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)) {
                            AsyncImage(
                                model = url,
                                contentDescription = "Place image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.Center),
                                placeholder = painterResource(id = R.drawable.connection_error),
                                error = painterResource(id = R.drawable.connection_error)
                            )
                            val locale = LocalContext.current.resources.configuration.locales[0]
                            Text(text = NumberFormatUtils.formatCurrency(locale, place.price), color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = Modifier
                                .padding(8.dp)
                                .align(
                                    Alignment.BottomEnd
                                ))
                        }

                    }
                }

                item {
                    Row {
                        Text(
                            place.name,
                            style = MaterialTheme.typography.headlineSmall,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                item {
                    Column(
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)) {

                        Text(place.address, overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.titleMedium)

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Star, contentDescription = "Average of stars", modifier = Modifier
                                .padding(end = 4.dp)
                                .scale(0.8f))
                            Text(
                                stringResource(
                                    R.string.place_details_stats_and_reviews,
                                    place.starts,
                                    place.reviews
                                ), overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.titleSmall)
                        }
                    }
                }

                item {
                    Row {
                        Text(
                            place.description,
                            style = MaterialTheme.typography.bodyMedium,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                item {
                    Surface(modifier = Modifier.padding(16.dp)) {
                        PlaceDetailsScoreReview(
                            rate = place.starts,
                            reviews = place.reviews
                        )
                    }
                }

                item {
                    UIItemTale(title = stringResource(R.string.place_details_dedicated_workspace), description = stringResource(
                        R.string.place_details_dedicated_workspace_description
                    ), iconContent = {
                        Icon(painter = painterResource(id = R.drawable.ic_table_restaurant_24), contentDescription = "Workspace available")
                    })

                    UIItemTale(title = stringResource(R.string.place_details_extra_bed), description = stringResource(
                        R.string.place_details_extra_bed_description
                    ), iconContent = {
                        Icon(painter = painterResource(id = R.drawable.ic_bed), contentDescription = "Extra bed available")
                    })

                    UIItemTale(title = stringResource(R.string.place_details_free_cancellation), description = stringResource(
                        R.string.place_details_free_cancellation_description
                    ), iconContent = {
                        Icon(painter = painterResource(id = R.drawable.ic_calendar_24), contentDescription = "Calendar cancellation")
                    })

                    Divider(Modifier.padding(16.dp))
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
fun PlaceDetailsScreenPreview() {
    AirbnbTheme {
        PlaceDetailsScreen(placeId = 1)
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun PlaceDetailsScreenNightPreview() {
    AirbnbTheme {
        PlaceDetailsScreen(placeId = 1)
    }
}