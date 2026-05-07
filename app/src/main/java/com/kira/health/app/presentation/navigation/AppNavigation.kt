package com.kira.health.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kira.health.app.presentation.screens.home.HomeScreen
import com.kira.health.app.presentation.screens.home.HomeViewModel
import com.kira.health.app.presentation.screens.login.LoginScreen

object AppDestinations {
    const val LOGIN = "login"
    const val HOME = "home"
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = AppDestinations.LOGIN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppDestinations.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppDestinations.HOME) {
                        popUpTo(AppDestinations.LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(AppDestinations.HOME) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                onLogoutClick = {
                    homeViewModel.logout()
                    navController.navigate(AppDestinations.LOGIN) {
                        popUpTo(AppDestinations.HOME) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
