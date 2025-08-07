package com.demo.airbnb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.demo.airbnb.ui.AppRouter
import com.demo.airbnb.ui.features.home.HomeScreen
import com.demo.airbnb.ui.features.home.HomeVM
import com.demo.airbnb.ui.features.login.LoginScreen
import com.demo.airbnb.ui.features.placedetails.PlaceDetailsScreen
import com.demo.airbnb.ui.theme.AirbnbTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppRouter.loginPath
            ) {
                composable(AppRouter.loginPath) {
                    AirbnbTheme {
                        LoginScreen(
                            navController = navController
                        )
                    }
                }
                composable(AppRouter.homePath) {
                    val homeVM: HomeVM by viewModels()
                    AirbnbTheme {
                        HomeScreen(
                            uiState = homeVM.uiState,
                            navigateToPlaceDetails = { navController.navigate(AppRouter.placeDetailsPath(it.id)) }
                        )
                    }
                }
                composable(
                    AppRouter.placeDetailsPath, arguments = listOf(
                    navArgument("id") { type = NavType.IntType; defaultValue = 0 }
                )) {
                    val placeId = it.arguments?.getInt("id") ?: 0
                    AirbnbTheme {
                        PlaceDetailsScreen(
                            placeId = placeId,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
