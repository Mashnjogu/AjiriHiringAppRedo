package com.njogu.ajirihiringredone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.njogu.ajirihiringredone.authentication.AuthenticationViewModel
import com.njogu.ajirihiringredone.authentication.ForgotPassword
import com.njogu.ajirihiringredone.authentication.SignIn
import com.njogu.ajirihiringredone.authentication.SignUp
import com.njogu.ajirihiringredone.bottomNavScreens.AddTaskScreen
import com.njogu.ajirihiringredone.bottomNavScreens.DisplayTaskScreen
import com.njogu.ajirihiringredone.bottomNavScreens.MessagesScreen
import com.njogu.ajirihiringredone.bottomNavScreens.NotificationScreen
import com.njogu.ajirihiringredone.navigation.BottomNavScreens
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.taskcategoriesandinfo.HomeScreen
import com.njogu.ajirihiringredone.ui.theme.AjiriHiringRedoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AjiriHiringRedoneTheme {
                // A surface container using the 'background' color from the theme
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
                            SignUp(navController = navController, authViewModel = AuthenticationViewModel())
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
    }
}


