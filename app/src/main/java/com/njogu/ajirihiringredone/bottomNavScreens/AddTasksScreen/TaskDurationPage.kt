package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshoe.kalendar.Kalendar
import com.himanshoe.kalendar.model.KalendarType
import com.njogu.ajirihiringredone.ui.theme.Purple700


@Composable
fun TaskDurationPage(){
    Column {

    }
}

@Preview(showBackground = true)
@Composable
fun TaskDurationPreview(){
    TaskDurationPage()
}


//@Composable
//fun TaskDurationPage(){
//
//    var pickedDate by remember{
//        mutableStateOf(
//            LocalDate.now())
//    }
//    var pickedTime by remember {
//        mutableStateOf(LocalTime.NOON)
//    }
//    val formattedDate by remember {
//        derivedStateOf {
//            DateTimeFormatter.ofPattern("MMM dd yyyy")
//                .format(pickedDate)
//        }
//    }
//    val formattedTime by remember {
//        derivedStateOf {
//            DateTimeFormatter.ofPattern("hh:mm")
//                .format(pickedTime)
//        }
//    }
//
//    val dateDialogState = rememberMaterialDialogState()
//    val timeDialogState = rememberMaterialDialogState()
//
//    val colors: TimePickerColors = if (isSystemInDarkTheme()) {
//        TimePickerDefaults.colors(
//            activeBackgroundColor = Color.Green.copy(0.3f),
//            activeTextColor = Color.White,
//            selectorColor = Color.Green,
//            inactiveBackgroundColor = Color(0xFF292929)
//        )
//    } else {
//        TimePickerDefaults.colors(
//            inactiveBackgroundColor = Color.LightGray,
//            activeBackgroundColor = Color.Red .copy(0.8f),
//            activeTextColor = Color.White,
//            selectorColor = Color.Black.copy(0.8f)
//        )
//    }
//
//    var dateTimeText by remember{
//        mutableStateOf("Day of the task")
//    }
//    var timeTextText by remember{
//        mutableStateOf("Choose the time of the day")
//    }
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(horizontal = 12.dp)) {
//        Text(text = "Choose when you would like your tasks to start")
//        Spacer(modifier = Modifier.height(60.dp))
//        Text(text = "Date")
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Box(
//                modifier = Modifier
//                    .border(
//                        1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
//                    )
//                    .clickable {
//                        dateDialogState.show()
//
//                    }
//            ) {
//
//                Row(modifier = Modifier
//                    .padding(12.dp)
//                    .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text(
//                        text = dateTimeText,
//                    )
//
//                    Icon(
//                        imageVector = Icons.Default.DateRange,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(20.dp, 20.dp)
//                        ,
//                        tint = MaterialTheme.colors.onSurface
//                    )
//                }
//
//            }
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//        Text(text = "Time of the Day")
//        Spacer(modifier = Modifier.height(20.dp))
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Box(
//                modifier = Modifier
//                    .border(
//                        1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
//                    )
//                    .clickable {
//                        timeDialogState.show()
//                    }
//            ) {
//                Row(modifier = Modifier
//                    .padding(12.dp)
//                    .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text(
//                        text = timeTextText,
//                    )
//
//                    Icon(
//                        imageVector = Icons.Filled.Star,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(20.dp, 20.dp)
//                        ,
//                        tint = MaterialTheme.colors.onSurface
//                    )
//                }
//
//            }
//
//
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//        MaterialDialog(
//            dialogState = dateDialogState,
//            buttons = {
//                positiveButton(text = "Ok"){
//
//                }
//                negativeButton(text = "Cancel"){
//
//                }
//            }
//        ){
//            datepicker(
//                title = "Pick the date to start your task",
//                initialDate = LocalDate.now(),
//                allowedDateValidator = {
//                  it.equals(LocalDate.now()) || it.isAfter(LocalDate.now())
//                }
//            ){
//                pickedDate = it
//                dateTimeText = pickedDate.toString()
//                Log.d("Picking Date", "The picked date is: ${pickedDate}")
//                Log.d("DateTime is", "The picked dateTime is: ${dateTimeText}")
//            }
//        }
//
//        MaterialDialog(
//            dialogState = timeDialogState,
//            buttons = {
//                positiveButton(text = "Ok"){
//
//                }
//                negativeButton(text = "Cancel"){
//
//                }
//            }
//        ){
//            timepicker(
//                colors = colors ,
//                title = "Pick the time to start your task",
//                initialTime = LocalTime.now(),
//                is24HourClock = false
//            ){
//                pickedTime = it
//                timeTextText = pickedTime.toString()
//            }
//        }
//    }
//}



