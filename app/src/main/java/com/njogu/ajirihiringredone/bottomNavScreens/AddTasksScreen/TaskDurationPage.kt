package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.TimePickerColors
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@Composable
fun TaskDurationPage(){

    var pickedDate by remember{
        mutableStateOf(
            LocalDate.now())
    }
    var pickedTime by remember {
        mutableStateOf(LocalTime.NOON)
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MMM dd yyyy")
                .format(pickedDate)
        }
    }
    val formattedTime by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("hh:mm")
                .format(pickedTime)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()

    val colors: TimePickerColors = if (isSystemInDarkTheme()) {
        TimePickerDefaults.colors(
            activeBackgroundColor = Color.Green.copy(0.3f),
            activeTextColor = Color.White,
            selectorColor = Color.Green,
            inactiveBackgroundColor = Color(0xFF292929)
        )
    } else {
        TimePickerDefaults.colors(
            inactiveBackgroundColor = Color.LightGray,
            activeBackgroundColor = Color.Red .copy(0.8f),
            activeTextColor = Color.White,
            selectorColor = Color.Black.copy(0.8f)
        )
    }

    var dateTimeText by remember{
        mutableStateOf("Day of the task")
    }
    var timeTextText by remember{
        mutableStateOf("Choose the time of the day")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 12.dp)) {
        Text(text = "Choose when you would like your tasks to start")
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Date")
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .border(
                        1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                    )
                    .clickable {
                        dateDialogState.show()
                    }
            ) {

                Row(modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = dateTimeText,
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
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .border(
                        1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                    )
                    .clickable {
                        timeDialogState.show()
                    }
            ) {
                Row(modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = timeTextText,
                    )

                    Icon(
                        imageVector = Icons.Filled.Star,
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
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(text = "Ok"){

                }
                negativeButton(text = "Cancel"){

                }
            }
        ){
            datepicker(
                title = "Pick the date to start your task",
                initialDate = LocalDate.now(),
                allowedDateValidator = {
                  it.equals(LocalDate.now()) || it.isAfter(LocalDate.now())
                }
            ){
                pickedDate = it
                dateTimeText = pickedDate.toString()
                Log.d("Picking Date", "The picked date is: ${pickedDate}")
                Log.d("DateTime is", "The picked dateTime is: ${dateTimeText}")
            }
        }

        MaterialDialog(
            dialogState = timeDialogState,
            buttons = {
                positiveButton(text = "Ok"){

                }
                negativeButton(text = "Cancel"){

                }
            }
        ){
            timepicker(
                colors = colors ,
                title = "Pick the time to start your task",
                initialTime = LocalTime.now(),
                is24HourClock = false
            ){
                pickedTime = it
                timeTextText = pickedTime.toString()
            }
        }
    }
}



