package com.njogu.ajirihiringredone.taskcategoriesandinfo.navigationdrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AjiriNavDrawer(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Navigation Drawer")
        Text(text = "User Info will be displayed here")
        Text(text = "User can log out from here")
    }
}