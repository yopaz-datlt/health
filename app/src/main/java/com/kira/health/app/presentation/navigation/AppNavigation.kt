package com.kira.health.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kira.health.app.presentation.screens.home.GoalsScreen
import com.kira.health.app.presentation.screens.home.HomeScreen
import com.kira.health.app.presentation.screens.home.HomeViewModel
import com.kira.health.app.presentation.screens.login.LoginScreen

object AppDestinations {
    const val GOALS = "goals"
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = AppDestinations.GOALS
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppDestinations.GOALS) {
            GoalsScreen()
        }
    }
}
