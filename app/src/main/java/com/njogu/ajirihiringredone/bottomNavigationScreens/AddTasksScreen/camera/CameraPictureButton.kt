package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen.camera

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.njogu.ajirihiringredone.homescreen.composables.CircleShape

@Composable
fun CameraPictureButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
    ){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val color = if (isPressed) Color.Blue else Color.Black
    val contentPadding = PaddingValues(if (isPressed) 8.dp else 12.dp)
    
    OutlinedButton(
        modifier = modifier,
        shape = androidx.compose.foundation.shape.CircleShape,
        border = BorderStroke(width = 2.dp, color = Color.Black),
        contentPadding = contentPadding,
        onClick = {},
        enabled = false
    ) {
        Button(
            modifier = modifier.fillMaxSize(),
            shape = androidx.compose.foundation.shape.CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
            interactionSource = interactionSource,
            onClick = onClick
        ) {
            
        }
    }
}

@Preview
@Composable
fun PreviewCapturePictureButton(){
    Scaffold(
        modifier = Modifier
            .size(125.dp)
            .wrapContentSize()
    ) { innerPadding ->
        CameraPictureButton(
            modifier = Modifier
                .padding(innerPadding)
                .size(100.dp)
        )
    }
}