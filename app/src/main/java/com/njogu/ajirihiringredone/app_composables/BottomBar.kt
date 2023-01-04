package com.njogu.ajirihiringredone.app_composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.njogu.ajirihiringredone.navigation.BottomNavScreens

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomNavScreens.DisplayTasks,
        BottomNavScreens.Messages,
        BottomNavScreens.Notifications
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(elevation = 8.dp) {
        screens.forEach{screen ->
            if (currentDestination != null) {
                AddItem(
                    screens = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screens: BottomNavScreens,
    currentDestination: NavDestination,
    navController: NavHostController
){
    BottomNavigationItem(
        enabled = true,
        icon = {
               Icon(imageVector = screens.icon, contentDescription = "navigationItem")
        },
        selected = currentDestination.hierarchy.any {
            it.route == screens.route
        },
        onClick = {
            navController.navigate(screens.route)
        })
}