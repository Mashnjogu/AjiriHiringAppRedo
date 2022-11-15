package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp


@Composable
fun TaskDurationPage(){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 12.dp)) {
        Text(text = "Choose when you would like your tasks to start")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Date")
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .border(
                        1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                    )
                    .clickable {
//                        showDatePicker(activity,updatedDate )
                    }
            ) {
                Row(modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Choose the starting date",
                    )

                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp, 20.dp)
                        ,
                        tint = MaterialTheme.colors.onSurface
                    )
                }

            }


        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Time of the Day")
    }
}



