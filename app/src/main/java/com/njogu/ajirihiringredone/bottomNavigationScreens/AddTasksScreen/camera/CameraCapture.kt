package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.camera

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.core.UseCase
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.Permission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

@Composable
fun CameraCapture(
    modifier: Modifier = Modifier,
    onImageFile: (File) -> Unit = { },
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
){
    val context = LocalContext.current

    Permission(
        permission = Manifest.permission.CAMERA,
        rationale = "Your permission is required in order to take a picture",
        permissionNotAvailableContent = {
                     Column(modifier = Modifier.height(8.dp)) {
                         Text("No Camera")
                         Spacer(modifier = Modifier.height(8.dp))
                         Button(onClick = {
                             context.startActivity(
                                 Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                     data = Uri.fromParts("package", context.packageName, null)
                                 }
                             )
                         }) {
                             Text(text = "Open Settings")
                         }
                     }
        },
    ){
        Box(modifier = modifier) {

            val lifecycleOwner = LocalLifecycleOwner.current
            var previewUseCase by remember{
                mutableStateOf<UseCase>(Preview.Builder().build())
            }

            val imageCaptureUsecase by remember{
                mutableStateOf(
                    ImageCapture.Builder().setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY).build()
                )
            }

            val coroutineScope = rememberCoroutineScope()

            Box{
                CameraPreview(
                    modifier = Modifier.fillMaxSize(),
                    onUseCase = {
                        previewUseCase = it
                    }
                )
                CameraPictureButton(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .align(Alignment.BottomCenter),
                    onClick = {
                        coroutineScope.launch (Dispatchers.IO){
                            imageCaptureUsecase.takePicture(context.executor).let{
                                onImageFile(it)
                            }
                        }
                    }
                )

            }

            LaunchedEffect(previewUseCase){
                val cameraProvider = context.getCameraProvider()
                try {
                    // Must unbind the use-cases before rebinding them.
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, previewUseCase, imageCaptureUsecase)
                }catch (e: Exception){
                    Log.e("Camera Capture", "Failed to bind camera to use case", e)
                }
            }
        }
    }

}