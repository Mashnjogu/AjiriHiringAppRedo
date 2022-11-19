package com.njogu.ajirihiringredone.taskcategoriesandinfo

import android.accounts.Account
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.components.BottomBar
import com.njogu.ajirihiringredone.components.FloatingActionButtonCustomized
import com.njogu.ajirihiringredone.components.TaskCategoryCustomTopAppBar
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.AccountBalanceCard
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.JobStats
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.YetToBeReviewed
import com.njogu.ajirihiringredone.taskcategoriesandinfo.navigationdrawer.AjiriNavDrawer
import kotlinx.coroutines.launch

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
){
    val scrollState = rememberScrollState()
    val drawerScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TaskCategoryCustomTopAppBar(
                navController = navController,
                title = "Ajiri",
               onNavigationIconClick = {
                   drawerScope.launch {
                       scaffoldState.drawerState.open()
                   }
                   Log.d("Navigation Drawer", "Navigation Icon Clicked")
               }
            )
        },
        drawerContent = {
                        AjiriNavDrawer()
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
//    val months = mapOf(
//        1 to "January",
//        2 to "February",
//        3 to "March",
//        4 to "April",
//        5 to "May",
//        6 to "June",
//        7 to "July",
//        8 to "August",
//        9 to "September",
//        10 to "October",
//        11 to "November",
//        12 to "December",
//
//    )
    val months = listOf(
         "January",
         "February",
        "March",
        "April",
        "May",
        "June",
         "July",
        "August",
         "September",
         "October",
         "November",
         "December",

        )

    var isMonthTextExpanded by remember{
        mutableStateOf(false)
    }
    var mSelectedMonth by remember { mutableStateOf("") }
//    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (isMonthTextExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

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
//            DropdownMenu(
//                expanded = isMonthTextExpanded,
//                onDismissRequest = {
//                    isMonthTextExpanded = false
//                }) {
//                months.forEach { index, month ->
//                    DropdownMenuItem(onClick = {
//                        mSelectedMonth = month
//                        isMonthTextExpanded = false
//                    }) {
//                        Text(text = month)
//                    }
//                }
//            }
            DropdownDemo(months = months)


//            Text("October")
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


@Composable
fun DropdownDemo(months: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
//        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)) {
        Row(
            modifier = Modifier.clickable(onClick = {
                expanded = true
            })
        ) {
            Text(months[selectedIndex],
                modifier = Modifier
                    .width(100.dp)
//                    .clickable(onClick = { expanded = true })
                    .background(
                        Color.White
                    )
            )
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop Down Arrow")
        }


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White
                )
        ) {
            months.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = s)
//                    val disabledText = if (s == disabledValue) {
//                        " (Disabled)"
//                    } else {
//                        ""
//                    }
//                    Text(text = s + disabledText)
                }
            }

        }
    }
}






