package com.njogu.ajirihiringredone.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.components.CustomTopAppBar

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
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Forgot Password")
            }
        }
    )
}