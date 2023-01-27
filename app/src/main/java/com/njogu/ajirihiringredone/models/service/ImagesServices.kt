package com.njogu.ajirihiringredone.models.service

import android.net.Uri
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.model.Response
import kotlinx.coroutines.flow.Flow

interface ImagesServices{

    suspend fun addTaskImageToFirebaseStorage(image: Uri): Flow<Response<Uri>>

    suspend fun addTaskImagesToFirebaseStorage(image: List<Uri>): Flow<Response<List<Uri>>>

    suspend fun addTaskImagesToFirebaseFirestore(downlaodUrl: Uri): Flow<Response<Boolean>>

    suspend fun getImageFromFirestore(): Flow<Response<String>>

}
