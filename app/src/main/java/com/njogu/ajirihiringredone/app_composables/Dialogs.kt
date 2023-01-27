package com.njogu.ajirihiringredone.app_composables


import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.njogu.ajirihiringredone.utils.composables.BasicTextButton
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.AddTasksScreenViewModel
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.camera.CameraCapture
import com.njogu.ajirihiringredone.utils.composables.DialogCancelButton

val EMPTY_IMAGE_URI: Uri = Uri.parse("file://dev/null")

@OptIn(ExperimentalComposeUiApi::class, ExperimentalPermissionsApi::class)
@Composable
fun TakeorSelectPictureDialog(
    onDismiss: () -> Unit,
    onCameraSelected: () -> Unit,
    modifier: Modifier = Modifier,
    addTasksViewModel: AddTasksScreenViewModel
){
    var isCameraSelected by remember{mutableStateOf(false)}
    var imageUri by remember { mutableStateOf(EMPTY_IMAGE_URI) }
    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetMultipleContents()
    ){
        addTasksViewModel.updateSelectedImageList(it)
    }
    val permissionState = rememberPermissionState(
        permission = Manifest.permission.READ_EXTERNAL_STORAGE
    )

//    if (isCameraSelected){
//        Box(modifier = modifier){
//            CameraCapture(
//                modifier = modifier,
//                onImageFile = { file ->
//                    imageUri = file.toUri()
//                }
//            )
//        }
//
//    }

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        )
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Please select how you will choose the task image to continue",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Divider(thickness = 1.dp)
                BasicTextButton(text = R.string.select_photo, modifier = Modifier) {
//                        isCameraSelected = true
                    onCameraSelected()
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Divider(thickness = 1.dp)
                BasicTextButton(text = R.string.select_gallery, modifier = Modifier) {
                    if(permissionState.hasPermission){
                galleryLauncher.launch("image/*")
            }else{
                permissionState.launchPermissionRequest()
            }
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Divider(thickness = 1.dp)
                Row(horizontalArrangement = Arrangement.Center) {
                    DialogCancelButton(text = R.string.cancel_dialog) {
                        onDismiss()
                    }
                }

            }
        }
    }
}

