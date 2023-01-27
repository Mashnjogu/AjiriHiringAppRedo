package com.njogu.ajirihiringredone.models.impl

import android.net.Uri
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.model.Response
import com.njogu.ajirihiringredone.models.service.ImagesServices
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImagesServicesImpl
@Inject constructor(
    private val storage: FirebaseStorage,
    private val db: FirebaseFirestore
): ImagesServices{
    val taskImagePath =
    override suspend fun addTaskImageToFirebaseStorage(image: Uri): Flow<Response<Uri>> {
        return try{
            val downloadUrl = storage.reference.child("TaskImages").child()
        }catch (){

        }
    }

    override suspend fun addTaskImagesToFirebaseStorage(image: List<Uri>): Flow<Response<List<Uri>>> {
        TODO("Not yet implemented")
    }

    override suspend fun addTaskImagesToFirebaseFirestore(downlaodUrl: Uri): Flow<Response<Boolean>> {
        TODO("Not yet implemented")
    }

    override suspend fun getImageFromFirestore(): Flow<Response<String>> {
        TODO("Not yet implemented")
    }

}