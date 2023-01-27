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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.njogu.ajirihiringredone.authentication.ForgotPassword
import com.njogu.ajirihiringredone.authentication.SignIn
import com.njogu.ajirihiringredone.authentication.SignUp
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTaskScreen
import com.njogu.ajirihiringredone.bottomNavigationScreens.DisplayTaskScreen
import com.njogu.ajirihiringredone.bottomNavigationScreens.MessagesScreen
import com.njogu.ajirihiringredone.bottomNavigationScreens.NotificationScreen
import com.njogu.ajirihiringredone.navigation.BottomNavScreens
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.homescreen.HomeScreen
import com.njogu.ajirihiringredone.ui.theme.AjiriHiringRedoneTheme
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarManager
import kotlinx.coroutines.CoroutineScope

@Composable
@ExperimentalMaterialApi
fun AjiriHiringApp(){
    AjiriHiringRedoneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background

        ) {
            val appState = rememberAppState()
            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = it,
                        modifier = Modifier.padding(8.dp),
                        snackbar = { snackbarData ->
                            Snackbar(snackbarData, contentColor = MaterialTheme.colors.onPrimary)
                        }
                    )
                },
                scaffoldState = appState.scaffoldState
            ) { innerPaddingModifier ->
                NavHost(
                    navController = appState.navController,
                    startDestination = Routes.Login.route,
                    modifier = Modifier.padding(innerPaddingModifier)
                ){
                    ajiriHiringGraph(appState, appState.navController)
                }
            }

//            val navController = rememberNavController()
//
//            NavHost(navController = navController, startDestination = Routes.Login.route){
//                composable(Routes.Login.route){
//                    SignIn(navController = navController)
//                }
//                composable(Routes.SignUp.route){
//
//                    SignUp(
//                    navController = navController
//                    )
//                }
//                composable(Routes.ForgotPassword.route){
//                    ForgotPassword(navController = navController)
//                }
//                composable(Routes.HomeScreen.route){
//                    HomeScreen(navController = navController)
//                }
//                composable(BottomNavScreens.DisplayTasks.route){
//                    DisplayTaskScreen()
//                }
//                composable(BottomNavScreens.Messages.route){
//                    MessagesScreen()
//                }
//                composable(BottomNavScreens.Notifications.route){
//                    NotificationScreen()
//                }
//                composable(Routes.AddTask.route){
//                    AddTaskScreen()
//                }
//
//            }

        }
    }
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(scaffoldState, navController, snackbarManager, resources, coroutineScope){
    AjiriAppState(scaffoldState,navController,snackbarManager,resources,coroutineScope)
}

@Composable
@ReadOnlyComposable
fun resources(): Resources{
    return LocalContext.current.resources
}

fun NavGraphBuilder.ajiriHiringGraph(appState: AjiriAppState, navController: NavHostController){
    composable(Routes.Login.route){
        SignIn(
            navController = navController,
            openAndPopUp = { route, popUp ->
                appState.navigateAndPopUp(route, popUp)
            }
        )
    }
    composable(Routes.SignUp.route){
        SignUp(
            navController = navController,
            openAndPopUp = { route, popUp ->
                appState.navigateAndPopUp(route, popUp)
            }
        )
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
        AddTaskScreen(modifier = Modifier.fillMaxSize())
    }
}



