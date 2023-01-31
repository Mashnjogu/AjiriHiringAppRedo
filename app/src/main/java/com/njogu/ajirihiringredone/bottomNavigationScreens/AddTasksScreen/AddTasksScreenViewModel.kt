package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.model.Response
import com.njogu.ajirihiringredone.models.service.ImagesServices
import com.njogu.ajirihiringredone.models.service.LogService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTasksScreenViewModel @Inject constructor(
    logService: LogService,
    private val imagesServices: ImagesServices
) : ViewModel(){

    var imageState by mutableStateOf(TaskImageState())
    private set

    var addImagesToStorage by mutableStateOf<Response<List<Uri>>>(Response.Success(null))
    private set

    private lateinit var updatedImageList: List<Uri>


//    var isDialogShown by mutableStateOf(false)
//    private set
//
//    fun onTakePictureSelected(){
//        isDialogShown = true
//    }
//
//    fun onDismissDialog(){
//        isDialogShown = false
//    }
//    val task = mutableStateOf(TasksDetails())


    fun updateSelectedImageList(listOfImages: List<Uri>){
        updatedImageList = imageState.listOfSelectedTaskImages.toMutableList()
        viewModelScope.launch {
            updatedImageList += listOfImages
            imageState = imageState.copy(listOfSelectedTaskImages = updatedImageList.distinct())
        }
    }

    fun onImageItemRemove(index: Int){
        updatedImageList = imageState.listOfSelectedTaskImages.toMutableList()
        viewModelScope.launch {
            (updatedImageList as MutableList<Uri>).removeAt(index)
            imageState = imageState.copy(listOfSelectedTaskImages = updatedImageList.distinct())
        }
    }

    fun addImagesToFirebaseStorage(){
        viewModelScope.launch {
            addImagesToStorage = Response.Loading
            Log.d("Uploading to Firestore Storage", "$updatedImageList")
            addImagesToStorage = imagesServices.addTaskImagesToFirebaseStorage(updatedImageList)
        }
    }
}