package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.njogu.ajirihiringredone.ui.theme.*

@Composable
fun YetToBeReviewed(){

    Box(modifier = Modifier.height(200.dp)){
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start= 8.dp, end = 8.dp)
        ){
            item{
                ListItem()
                Spacer(modifier = Modifier.height(8.dp))
                ListItem()
                Spacer(modifier = Modifier.height(8.dp))
                ListItem()
                Spacer(modifier = Modifier.height(8.dp))
                ListItem()
                Spacer(modifier = Modifier.height(8.dp))
                ListItem()
                Spacer(modifier = Modifier.height(8.dp))
                ListItem()
            }
        }
    }

}

@Composable
fun ListItem(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth()
//            .border(1.dp, color = Color.LightGray),
                ,
        border = BorderStroke(2.dp, brush = Brush.radialGradient(
            colors = listOf(
                Purple500,
                Malibu
            )
        )),
        elevation = 8.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(12.dp),
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(8.dp)
                ){
//            Icon(imageVector = Icons.Default.Person, contentDescription = "")
            Card(
                shape = CircleShape,
                border = BorderStroke(3.dp, color = Color.Black),

            ) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "",
                    modifier = Modifier.padding(4.dp)
                )
            }
//            CircleShape()
            Text(text = "76 new candidates")
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Click to learn more")
        }
    }

}

@Composable
fun CircleShape(){
    IconInside(shape = CircleShape)
}

@Composable
fun IconInside(shape: Shape){
    Box(modifier = Modifier
        .size(20.dp, 20.dp)
        .background(color = Color.Red)
        .wrapContentSize(Alignment.Center)) {
        Icon(imageVector = Icons.Default.Person, contentDescription = "")
    }
}