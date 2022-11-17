package com.njogu.ajirihiringredone.taskcategoriesandinfo

import android.accounts.Account
import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.AccountBalanceCard
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.JobStats
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.YetToBeReviewed

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
){
    val scrollState = rememberScrollState()
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
        content = { padding ->

            Dashboard(scrollState = scrollState, padding = padding)

        }
    )

}

@Composable
fun Dashboard(
    padding: PaddingValues,
    scrollState: ScrollState
){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .padding(horizontal = 12.dp)
        .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Account Details")
            Text(">")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            AccountBalanceCard(
                heading1 = "ACCOUNT",
                heading2 = "BALANCE",
                amount = "230000",

            )
            AccountBalanceCard(
                heading1 = "EXPENDITURE",
                heading2 = "BALANCE",
                amount = "23000",

                )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "To be reviewed")
            Text("10 oct - 19 oct")
        }
        Spacer(modifier = Modifier.height(20.dp))
        YetToBeReviewed()
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Job Statistics")
            Text(">")
        }
        Spacer(modifier = Modifier.height(20.dp))
        JobStats()
        Spacer(modifier = Modifier.height(20.dp))
    }
}






