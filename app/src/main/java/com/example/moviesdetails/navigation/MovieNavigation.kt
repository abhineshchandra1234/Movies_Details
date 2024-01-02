package com.example.moviesdetails.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesdetails.screens.details.DetailsScreen
import com.example.moviesdetails.screens.home.HomeScreen


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }
    }
}