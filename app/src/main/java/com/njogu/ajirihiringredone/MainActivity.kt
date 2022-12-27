package com.njogu.ajirihiringredone

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AjiriHiringApp()
        }
    }
}





