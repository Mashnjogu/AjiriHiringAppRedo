package com.njogu.ajirihiringredone

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarManager
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarMessage.Companion.toMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class AjiriAppState (
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val snackbarManager: SnackbarManager,
    private val resources: Resources,
    coroutineScope: CoroutineScope
        ){

    init {
        coroutineScope.launch {
            snackbarManager.snackbarMessages.filterNotNull().collect{ snackBarMessage ->
                val text = snackBarMessage.toMessage(resources)
                scaffoldState.snackbarHostState.showSnackbar(text)
            }
        }
    }

    fun popUp(){
        navController.popBackStack()
    }

    fun navigate(route: String){
        navController.navigate(route){
            launchSingleTop = true
        }
    }

    fun navigateAndPopUp(route: String, popUpRoute:String){
        navController.navigate(route){
            launchSingleTop = true
            popUpTo(popUpRoute){
                inclusive = true
            }
        }
    }

    fun clearAndNavigate(route: String){
        navController.navigate(route){
            launchSingleTop = true
            popUpTo(0){
                inclusive = true
            }
        }
    }
}