package com.njogu.ajirihiringredone.taskcategoriesandinfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.components.BottomBar
import com.njogu.ajirihiringredone.components.FloatingActionButtonCustomized
import com.njogu.ajirihiringredone.components.TaskCategoryCustomTopAppBar
import com.njogu.ajirihiringredone.navigation.Routes

@Composable
fun HomeScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            TaskCategoryCustomTopAppBar(navController = navController, title = "Ajiri")
        },
        bottomBar = {
        BottomBar(navController = navController)
    },
        floatingActionButton = {
            FloatingActionButtonCustomized(
                onClick = {
                          navController.navigate(Routes.AddTask.route)
                },
                text = {
                       Text(text = "Add task")
                },
                modifier = Modifier.padding(16.dp),
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                }
            )

        },
        floatingActionButtonPosition = FabPosition.End,
        content = {
            Dashboard()
        }
    )

}

@Composable
fun Dashboard(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Dashboard")
        Text("Account Deatils")
        Text("To be reviewed")
        Text("Job statistics")
    }
}




