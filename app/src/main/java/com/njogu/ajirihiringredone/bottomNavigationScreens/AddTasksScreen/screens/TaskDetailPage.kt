package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.app_composables.EMPTY_IMAGE_URI
import com.njogu.ajirihiringredone.app_composables.TakeorSelectPictureDialog
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.camera.CameraCapture

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun TaskDetailPage(
    modifier: Modifier = Modifier
){

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

//    var isImageSelected = false
    var isImageSelected by remember {
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

    // from the medium article on CameraX
    val emptyImageUri = Uri.parse("file://dev/null")
    var imageUri by remember{ mutableStateOf(emptyImageUri) }

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (isImageSelected){
                Text(text = "Task Images")
                TextButton(onClick = {
                    galleryLauncher.launch("image/*")

                }) {
                    Text(text = "Add Task Image", color = MaterialTheme.colors.primary)
                }
            }else{
                Text(text = "Task Images")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        if(imageState.listOfSelectedTaskImages.isEmpty()){
            isImageSelected = false
            TaskImage(addTasksViewModel, modifier = modifier)
        }else if (imageState.listOfSelectedTaskImages.isNotEmpty()){
            isImageSelected = true
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ){
                itemsIndexed(imageState.listOfSelectedTaskImages){ index, url ->
                    TaskImageItem(uri = url, onItemClick = {
                        addTasksViewModel.onImageItemRemove(index)
                    })
                    Spacer(modifier = Modifier.width(18.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun TaskImage(
    addTasksViewModel: AddTasksScreenViewModel,
    modifier: Modifier = Modifier
){

    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetMultipleContents()
    ){
        addTasksViewModel.updateSelectedImageList(it)
    }
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    if (addTasksViewModel.isDialogShown){
        TakeorSelectPictureDialog(
            onDismiss = { addTasksViewModel.onDismissDialog() },
            onCameraSelected = {addTasksViewModel.onCameraChosen()},
            addTasksViewModel = addTasksViewModel
        )
    }

    var imageUri by remember { mutableStateOf(com.njogu.ajirihiringredone.app_composables.EMPTY_IMAGE_URI) }


    Card(
        modifier = Modifier
            .height(140.dp)
            .width(140.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        backgroundColor = Color.LightGray
    ) {

        IconButton(onClick = {
            if(permissionState.hasPermission){
                galleryLauncher.launch("image/*")
            }else{
                permissionState.launchPermissionRequest()
            }
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_add_a_photo_24),
                contentDescription = "Select photo to upload", modifier = Modifier
                    .height(130.dp)
                    .width(130.dp))
        }
    }
}


@Composable
fun TaskImageItem(
    uri: Uri,
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
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            IconButton(onClick = {onItemClick()}) {
                Icon(
                    tint = Color.Red,
                    modifier = Modifier.padding(5.dp),
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
    }
    }
}








