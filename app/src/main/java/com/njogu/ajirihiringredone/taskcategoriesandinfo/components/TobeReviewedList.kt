package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(8.dp)
                ){
            Icon(imageVector = Icons.Default.Person, contentDescription = "")
            Text(text = "76 new candidates")
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Click to learn more")
        }
    }

}