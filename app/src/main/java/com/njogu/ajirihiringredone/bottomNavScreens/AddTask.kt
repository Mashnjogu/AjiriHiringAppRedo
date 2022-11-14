package com.njogu.ajirihiringredone.bottomNavScreens


import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.njogu.ajirihiringredone.ui.theme.Denim
import com.njogu.ajirihiringredone.ui.theme.Malibu
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddTaskScreen(){
    val tabItems = listOf("Task Details", "Task Duration", "Task Budget")
    val pagerState = rememberPagerState(pageCount = tabItems.size)
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = Malibu,
            modifier = Modifier
                .padding(all = 20.dp)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(30.dp)),
            indicator = {
                tabPositions -> TabRowDefaults.Indicator(
                Modifier
                    .pagerTabIndicatorOffset(
                        pagerState = pagerState,
                        tabPositions = tabPositions
                    )
                    .width(0.dp)
                    .height(0.dp)
                )
            }
        ) {
            tabItems.forEachIndexed { index, title ->
                val color = remember{
                    Animatable(Denim)
                }
                LaunchedEffect(key1 = pagerState.currentPage == index){
                    color.animateTo(
                        if(pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                }
                Tab(
                    text = {
                           Text(text = title, style = if (pagerState.currentPage == index)
                               TextStyle(color = Color.Red, fontSize = 18.sp)
                           else TextStyle(color = Color.Red, fontSize = 16.sp)
                           )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier.background(color = color.value, shape = RoundedCornerShape(30.dp)),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })


            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when(page){
                0 -> {
                    TaskDetailPage()
                }
                1 -> {
                    TaskDurationPage()
                }
                2 -> {
                    TaskBudgetPage()
                }
            }
        }

    }
}

@Composable
fun TaskDetailPage(){

    val taskName = remember{
        mutableStateOf(TextFieldValue())
    }
    val taskDescription = remember{
        mutableStateOf(TextFieldValue())
    }
    val taskRequirements = remember{
        mutableStateOf(TextFieldValue())
    }
    val configuration = LocalConfiguration.current
    val scrollState = rememberScrollState()
    var visible by remember{
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 12.dp)
        .verticalScroll(scrollState)
    ) {
        OutlinedTextField(
            label = {Text(text = "Task Name")},
            value = taskName.value,
            onValueChange = {taskName.value = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = {Text(text = "Task Description")},
            value = taskDescription.value,
            onValueChange = {taskDescription.value = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = {Text(text = "Task Requirements")},
            value = taskRequirements.value,
            onValueChange = {taskRequirements.value = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(onClick = {
            visible = !visible
        }) {
            Text(text = "Click here to enter the task location")
        }
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(1000)) +
                    expandVertically (
                        animationSpec = tween(1500,
                            )),
            exit = fadeOut(animationSpec = tween(1000)) +
                    shrinkVertically (
                        animationSpec = tween(1000,
                        )),
        ) {
            Box(modifier = Modifier
                .height(
                    (configuration.screenHeightDp * 0.3).dp
                )
                .fillMaxWidth()
                .background(color = Color.Red)){}
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Task Images")
        Spacer(modifier = Modifier.height(20.dp))
        TaskImages()
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Next >")
        }

    }
}

@Composable
fun TaskImages(){
    val images = listOf<String>("sjsjs", "sss")

   Card(
       modifier = Modifier
           .height(130.dp)
           .width(130.dp),
       shape = RoundedCornerShape(15.dp),
       elevation = 8.dp
   ) {
       Box(modifier = Modifier.fillMaxSize()){

           if (images.isEmpty()){
               Text("Image will appear here")
           }else{
               Icon(imageVector = Icons.Default.Delete, contentDescription = "")
//               AsyncImage(
//                   model = "https://images.unsplash.com/photo-1668027686570-aff6795ed3c1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",
//                   contentDescription = "msms"
//               )

           }

       }
   }
}

@Composable
fun TaskDurationPage(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "TaskDurationScreen")
    }
}

@Composable
fun TaskBudgetPage(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "TaskBudgetScreen")
    }
}
