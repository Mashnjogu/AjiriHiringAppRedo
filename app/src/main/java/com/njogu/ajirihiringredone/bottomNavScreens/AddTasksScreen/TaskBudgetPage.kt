package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TaskBudgetPage(){
    val totalTaskAmount  = remember{
        mutableStateOf(TextFieldValue())
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text("Please enter the tasks total amount")
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            label = {
                Text(text = "Total Amount")
            },
            value = totalTaskAmount.value,
            onValueChange = {
                totalTaskAmount.value = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
    }
}
