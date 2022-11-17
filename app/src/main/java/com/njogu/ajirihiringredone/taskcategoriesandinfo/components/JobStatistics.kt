package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JobStats(){
    LazyRow{
        item {
            JobStatsChip()
            Spacer(modifier = Modifier.width(8.dp))
            JobStatsChip()
            Spacer(modifier = Modifier.width(8.dp))
            JobStatsChip()
        }
    }
    Spacer(modifier = Modifier.height(20.dp))

    LazyRow{
        item {
            JobStatsCard()
            Spacer(modifier = Modifier.width(8.dp))
            JobStatsCard()
            Spacer(modifier = Modifier.width(8.dp))
            JobStatsCard()
        }
    }


}

@Composable
fun JobStatsChip(
    modifier: Modifier = Modifier
){
    Card(
        border = BorderStroke(2.dp, color = Color.Black),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Box(modifier = modifier.padding(10.dp)) {
            Text(text = "OverView")
        }

    }
}

@Composable
fun JobStatsCard(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.height(145.dp).width(145.dp),
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Applied")
            Spacer(modifier = modifier.height(10.dp))
            Text(text = "2,552")
        }
    }
}