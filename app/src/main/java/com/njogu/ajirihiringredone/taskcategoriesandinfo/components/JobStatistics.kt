package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.ui.theme.c1
import com.njogu.ajirihiringredone.ui.theme.c2

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
        border = BorderStroke(3.dp, brush = Brush.linearGradient(
            colors = listOf(
                c1, c2
            )
        )),
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
    modifier: Modifier = Modifier,

){
    Card(
        modifier = modifier.height(145.dp).width(145.dp),
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            c1, c2
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Applied", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(modifier = modifier.height(10.dp))
            Text(text = "2,552", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 18.sp)
        }
    }
}