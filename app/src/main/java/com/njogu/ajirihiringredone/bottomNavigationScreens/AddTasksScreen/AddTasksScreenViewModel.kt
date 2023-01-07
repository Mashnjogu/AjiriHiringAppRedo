package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njogu.ajirihiringredone.models.service.LogService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTasksScreenViewModel @Inject constructor(
    logService: LogService
) : ViewModel(){

    var imageState by mutableStateOf(TaskImageState())
    private set

    fun updateSelectedImageList(listOfImages: List<Uri>){
        val updatedImageList = imageState.listOfSelectedTaskImages.toMutableList()
        viewModelScope.launch {
            updatedImageList += listOfImages
            imageState = imageState.copy(listOfSelectedTaskImages = updatedImageList.distinct())
        }
    }

    fun onImageItemRemove(index: Int){
        val updatedImageList = imageState.listOfSelectedTaskImages.toMutableList()
        viewModelScope.launch {
            updatedImageList.removeAt(index)
            imageState = imageState.copy(listOfSelectedTaskImages = updatedImageList.distinct())
        }
    }
}