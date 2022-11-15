package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@Composable
fun TaskDurationPage(){

    var pickedDate by remember{
        mutableStateOf(LocalDate.now())
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
                        dateDialogState.show()
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
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(text = "Ok"){

                }
                negativeButton(text = "Cancel"){

                }
            }
        ){

        }
    }
}



