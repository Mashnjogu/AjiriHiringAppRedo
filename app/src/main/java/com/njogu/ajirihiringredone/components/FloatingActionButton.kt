package com.njogu.ajirihiringredone.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape


@Composable
fun FloatingActionButtonCustomized(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = MaterialTheme.colors.secondary,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation()
    ){

    ExtendedFloatingActionButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        elevation = elevation,
        shape = shape,
        icon = icon,
        interactionSource = interactionSource,
        contentColor = contentColor
    )
}