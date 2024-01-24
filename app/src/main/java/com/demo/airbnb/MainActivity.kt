package com.demo.airbnb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.demo.airbnb.ui.features.login.LoginVM
import com.demo.airbnb.ui.features.placedetails.PlaceDetailsScreen
import com.demo.airbnb.ui.features.placedetails.PlaceDetailsVM
import com.demo.airbnb.ui.theme.AirbnbTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppRouter.loginPath
            ) {
                composable(AppRouter.loginPath) {
                    val loginVM: LoginVM by viewModels()
                    AirbnbTheme {
                        LoginScreen(
                            uiState = loginVM.uiState,
                            signIn = loginVM::signIn,
                            navigateToHome = {
                                navController.navigate(AppRouter.homePath()) {
                                    popUpTo(AppRouter.loginPath()) { inclusive = true }
                                }
                            },
                        )
                    }
                }
                composable(AppRouter.homePath) {
                    val homeVM: HomeVM by viewModels()
                    AirbnbTheme {
                        HomeScreen(
                            uiState = homeVM.uiState,
                            navigateToPlaceDetails = { navController.navigate(AppRouter.placeDetailsPath(it.id))}
                        )
                    }
                }
                composable(AppRouter.placeDetailsPath, arguments = listOf(
                    navArgument("id") { type = NavType.IntType; defaultValue = 0 }
                )) {
                    val placeDetailsVM: PlaceDetailsVM by viewModels()
                    val placeId = it.arguments?.getInt("id") ?: 0

                    AirbnbTheme {
                        PlaceDetailsScreen(
                            uiState = placeDetailsVM.uiState,
                            placeId = placeId,
                            fetchPlace = placeDetailsVM::loadPlace
                        )
                    }
                }
            }
        }
    }
}
