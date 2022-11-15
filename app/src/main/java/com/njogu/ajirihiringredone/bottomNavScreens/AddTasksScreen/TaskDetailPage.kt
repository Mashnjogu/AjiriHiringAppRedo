package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

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
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Task Name") },
            value = taskName.value,
            onValueChange = {taskName.value = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Task Description") },
            value = taskDescription.value,
            onValueChange = {taskDescription.value = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Task Requirements") },
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
                        )
                    ),
            exit = fadeOut(animationSpec = tween(1000)) +
                    shrinkVertically (
                        animationSpec = tween(1000,
                        )
                    ),
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
//        Button(
//            modifier = Modifier.width((configuration.screenWidthDp * 0.45).dp).height(50.dp),
//            onClick = { /*TODO*/ }
//        ) {
//            Text(text = "Next >")
//        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

            },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .width((configuration.screenWidthDp * 0.8).dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Next")
        }

        Spacer(modifier = Modifier.height(25.dp))

    }
}

@Composable
fun TaskImages(){
    val images = listOf<String>("sjsjs", "sss")
    val painter =
        rememberImagePainter(
            data = "https://images.unsplash.com/photo-1668355518826-7cf007c5d3a9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        )

    Card(
        modifier = Modifier
            .height(130.dp)
            .width(130.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd){

            if (images.isEmpty()){
                Text("Image will appear here")
            }else{
                Image(
                    painter = painter,
                    contentDescription = "Forest Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        tint = Color.LightGray,
                        modifier = Modifier.padding(5.dp),
                        imageVector = Icons.Default.Delete,
                        contentDescription = ""
                    )
                }


            }

        }
    }
}