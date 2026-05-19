package com.kira.health.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kira.health.app.presentation.screens.care.CareScreen

object AppDestinations {
    const val CARE = "care"
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = AppDestinations.CARE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(AppDestinations.CARE) {
            CareScreen()
        }
    }
}
