package com.njogu.ajirihiringredone.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.app_composables.CustomTopAppBar

@Composable
fun ForgotPassword(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Box(modifier = modifier.fillMaxSize()) {
        ScaffoldWithForgotTopBar(navController = navController)
    }
}

@Composable
fun ScaffoldWithForgotTopBar(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopAppBar(navController = navController, title = "Forgot Password", showBackIcon = true)
        },
        content = { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Forgot Password")
            }
        }
    )
}