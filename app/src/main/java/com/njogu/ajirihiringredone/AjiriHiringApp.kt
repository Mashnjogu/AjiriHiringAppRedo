package com.njogu.ajirihiringredone

import android.content.res.Resources
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.njogu.ajirihiringredone.authentication.ForgotPassword
import com.njogu.ajirihiringredone.authentication.SignIn
import com.njogu.ajirihiringredone.authentication.SignUp
import com.njogu.ajirihiringredone.authentication.screens.signup.SignUpViewModel
import com.njogu.ajirihiringredone.bottomNavScreens.AddTaskScreen
import com.njogu.ajirihiringredone.bottomNavScreens.DisplayTaskScreen
import com.njogu.ajirihiringredone.bottomNavScreens.MessagesScreen
import com.njogu.ajirihiringredone.bottomNavScreens.NotificationScreen
import com.njogu.ajirihiringredone.navigation.BottomNavScreens
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.taskcategoriesandinfo.HomeScreen
import com.njogu.ajirihiringredone.ui.theme.AjiriHiringRedoneTheme
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarManager
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarMessage
import kotlinx.coroutines.CoroutineScope

@Composable
@ExperimentalMaterialApi
fun AjiriHiringApp(){
    AjiriHiringRedoneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background

        ) {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.Login.route){
                composable(Routes.Login.route){
                    SignIn(navController = navController)
                }
                composable(Routes.SignUp.route){
                    SignUp(navController = navController, signUpViewModel = SignUpViewModel())
                }
                composable(Routes.ForgotPassword.route){
                    ForgotPassword(navController = navController)
                }
                composable(Routes.HomeScreen.route){
                    HomeScreen(navController = navController)
                }
                composable(BottomNavScreens.DisplayTasks.route){
                    DisplayTaskScreen()
                }
                composable(BottomNavScreens.Messages.route){
                    MessagesScreen()
                }
                composable(BottomNavScreens.Notifications.route){
                    NotificationScreen()
                }
                composable(Routes.AddTask.route){
                    AddTaskScreen()
                }

            }

        }
    }
}



