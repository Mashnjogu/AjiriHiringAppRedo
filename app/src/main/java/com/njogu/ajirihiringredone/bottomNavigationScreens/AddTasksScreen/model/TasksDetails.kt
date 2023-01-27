package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.model

import android.net.Uri
import java.net.URL

data class TasksDetails(
    val id: String = "",
    val taskName: String = "",
    val taskRequirements: String = "",
    val taskLocation: String = "",
    val taskImageStorageUrl: Uri,
    val taskDate: String = "",
    val taskTime: String = "",
    val taskAmount: String = ""
)
