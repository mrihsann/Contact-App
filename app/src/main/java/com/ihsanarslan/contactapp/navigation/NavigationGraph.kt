package com.ihsanarslan.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ihsanarslan.contactapp.navigation.Screen.Add
import com.ihsanarslan.contactapp.navigation.Screen.Home
import com.ihsanarslan.contactapp.navigation.Screen.Detail
import com.ihsanarslan.contactapp.navigation.Screen.Settings
import com.ihsanarslan.contactapp.ui.add.AddContactScreen
import com.ihsanarslan.contactapp.ui.detail.DetailScreen
import com.ihsanarslan.contactapp.ui.home.HomeScreen
import com.ihsanarslan.contactapp.ui.settings.SettingsScreen

@Composable
fun NavigationGraph(
    startDestination: Screen,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Detail> {
            DetailScreen(
                navController = navController)
        }
        composable<Settings> {
            SettingsScreen()
        }
        composable<Add> {
            AddContactScreen(navController = navController)
        }
    }
}