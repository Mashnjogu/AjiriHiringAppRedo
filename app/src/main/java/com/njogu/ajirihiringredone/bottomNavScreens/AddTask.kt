package com.njogu.ajirihiringredone.bottomNavScreens


import androidx.compose.animation.*

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen.TaskBudgetPage
import com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen.TaskDetailPage
import com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen.TaskDurationPage

import com.njogu.ajirihiringredone.ui.theme.Denim
import com.njogu.ajirihiringredone.ui.theme.Malibu
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddTaskScreen(){
    val tabItems = listOf("Task Details", "Task Duration", "Task Budget")
    val pagerState = rememberPagerState()
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
            count = tabItems.size,
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





