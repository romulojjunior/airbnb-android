package com.demo.airbnb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.airbnb.ui.features.home.HomeScreen
import com.demo.airbnb.ui.theme.AirbnbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirbnbTheme {
                HomeScreen()
            }
        }
    }
}
