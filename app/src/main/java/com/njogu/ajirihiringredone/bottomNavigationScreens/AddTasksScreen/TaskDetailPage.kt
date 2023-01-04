package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.njogu.ajirihiringredone.R

@OptIn(ExperimentalPermissionsApi::class)
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

    val addTasksViewModel = hiltViewModel<AddTasksScreenViewModel>()
    val imageState = addTasksViewModel.imageState
    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetMultipleContents()
    ){
        addTasksViewModel.updateSelectedImageList(it)
    }
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    SideEffect {
        permissionState.launchPermissionRequest()
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
                        animationSpec = tween(
                            1500,
                        )
                    ),
            exit = fadeOut(animationSpec = tween(1000)) +
                    shrinkVertically (
                        animationSpec = tween(
                            1000,
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

        TaskImagesList()
        Spacer(modifier = Modifier.height(25.dp))

    }
}

@Composable
fun TaskImage(){
    Card(
        modifier = Modifier
            .height(140.dp)
            .width(140.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        backgroundColor = Color.LightGray
    ) {

        IconButton(onClick = {

        }) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_add_a_photo_24),
                contentDescription = "Select photo to upload", modifier = Modifier
                    .height(130.dp)
                    .width(130.dp))
        }
    }
}


@Composable
fun TaskImagesList(){
    TaskImage()
    LazyRow{

    }
}

@Composable
fun TaskImageItem(
    uri: Uri,
    height: Dp,
    width: Dp,
    onItemClick: () -> Unit
    ){
    
    Card(
        modifier = Modifier
            .height(140.dp)
            .width(140.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        backgroundColor = Color.LightGray
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {

            AsyncImage(
                model = uri, contentDescription = "Task Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

            IconButton(onClick = {onItemClick()}) {
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
