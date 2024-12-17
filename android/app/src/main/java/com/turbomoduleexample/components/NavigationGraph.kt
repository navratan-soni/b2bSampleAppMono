package com.turbomoduleexample.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("feed") {
            FeedScreen(navController)
        }

        composable("start") {
//            BottomNavBar(navController)
            SearchScreen()
        }

        composable("account_screen/{accountName}") { backStackEntry ->
            val accountName = backStackEntry.arguments?.getString("accountName") ?: "Unknown"
            AccountDetailScreen()
        }
    }
}
