package com.njogu.ajirihiringredone.app_composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun SelectImageAlertDialog(
    dialogState: Boolean,
    onDismissRequest: (dialogState: Boolean) -> Unit
){
    if (dialogState){
        AlertDialog(
            onDismissRequest = { onDismissRequest(dialogState)},
            backgroundColor = Color.White,
            properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = false),
            shape = RoundedCornerShape(8.dp),
            buttons = {

            }
        )
    }
}

