package com.njogu.ajirihiringredone.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomTopAppBar(
    navController: NavHostController,
    title: String,
    showBackIcon: Boolean
){

    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = if (showBackIcon && navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = " Back"
                    )
                }
            }
        } else {
            null
        }
    )
}

@Composable
fun TaskCategoryCustomTopAppBar(
    navController: NavHostController,
    title: String,
    onNavigationIconClick: () -> Unit

){

    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
                         IconButton(onClick = onNavigationIconClick) {
                             Icon(imageVector = Icons.Rounded.Menu,
                                 contentDescription = "Call Navigation Drawer")
                         }
        },

        actions = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Account"),
//
//            }

        }

    )
}





