package com.njogu.ajirihiringredone.models.impl

import android.net.Uri
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.model.Response
import com.njogu.ajirihiringredone.models.service.ImagesServices
import com.njogu.ajirihiringredone.utils.await
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

class ImagesServicesImpl
@Inject constructor(
    private val storage: FirebaseStorage,
    private val db: FirebaseFirestore
): ImagesServices{
    val taskImagePath = UUID.randomUUID().toString()
    lateinit var downloadUrl: Uri
    override suspend fun addTaskImageToFirebaseStorage(image: Uri): Flow<Response<Uri>> {
        TODO("Not yet implemented")
    }

    override suspend fun addTaskImagesToFirebaseStorage(images: List<Uri>) : Response<List<Uri>>{
        val imagesUri: List<Uri> = withContext(Dispatchers.IO){
            images.map { image ->
                async {
                    storage.reference.child("Task Images").child(taskImagePath)
                        .putFile(image).await()
                        .storage.downloadUrl.await()
                }
            }.awaitAll()
        }
        return Response.Success(imagesUri)
    }

    override suspend fun addTaskImagesToFirebaseFirestore(downlaodUrl: Uri): Flow<Response<Boolean>> {
        TODO("Not yet implemented")
    }

    override suspend fun getImageFromFirestore(): Flow<Response<String>> {
        TODO("Not yet implemented")
    }

}