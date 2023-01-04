package com.njogu.ajirihiringredone.app_composables

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

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





