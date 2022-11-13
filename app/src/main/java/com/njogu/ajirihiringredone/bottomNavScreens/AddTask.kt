package com.njogu.ajirihiringredone.bottomNavScreens

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
                        if(pagerState.currentPage == index) Color.White else Color.Blue
                    )
                }
                Tab(
                    text = {
                           Text(text = title, style = if (pagerState.currentPage == index)
                               TextStyle(color = Denim, fontSize = 18.sp)
                           else TextStyle(color = Denim, fontSize = 16.sp)
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
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "TaskDetailScreen")
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
