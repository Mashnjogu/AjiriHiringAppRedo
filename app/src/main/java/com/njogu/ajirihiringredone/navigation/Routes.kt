package com.njogu.ajirihiringredone.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(val route: String){
    object Login: Routes("Login")
    object SignUp: Routes("SignUp")
    object ForgotPassword: Routes("Forgot Password")
    object HomeScreen: Routes("HomeScreen")
    object AddTask: Routes("AddTasks")
}

sealed class BottomNavScreens(
    val route: String,
    val icon: ImageVector
    ){
    object DisplayTasks: BottomNavScreens(
        route = "DisplayTasks",
        icon = Icons.Filled.Info
    )
    object Messages: BottomNavScreens(
        route = "Messages",
        icon = Icons.Default.Email
    )
    object Notifications: BottomNavScreens(
        route = "Notifications",
        icon = Icons.Default.Notifications
    )
}

