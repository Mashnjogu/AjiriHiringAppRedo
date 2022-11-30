package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.models.JobStat
import com.njogu.ajirihiringredone.models.getAllJobStatChips
import com.njogu.ajirihiringredone.ui.theme.c1
import com.njogu.ajirihiringredone.ui.theme.c2

@Composable
fun JobStatsChip(
    name: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onSelectedChange: (String) -> Unit
){
    Card(
        border = if (isSelected)
        BorderStroke(4.dp, brush = Brush.linearGradient(
            colors = listOf(
                c1, c2
            )
        )) else BorderStroke(2.dp, color = Color.Black),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Box(modifier = modifier.padding(10.dp)) {
            Row(
                modifier = modifier.toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectedChange(name)
                    }
                )
            ) {
                Text(
                    text = name,
                    fontWeight = if(isSelected) FontWeight.W600 else FontWeight.W400,
                    fontSize = if(isSelected) 18.sp else 15.sp
                )
            }

        }

    }
}


@Composable
fun JobStatChipGroup(
    jobStats: List<JobStat> = getAllJobStatChips(),
    selectedChip: JobStat ? = null,
    onSelectedChange: (String) -> Unit
){
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(jobStats){ job ->
                JobStatsChip(
                    name = job.name,
                    onSelectedChange = {
                        onSelectedChange(job.name)
                    },
                    isSelected = selectedChip == job
                )
            }
        }
    }
}

@Composable
fun JobStatsOverView(){
//    LazyRow{
//        item {
//            JobStatsChip()
//            Spacer(modifier = Modifier.width(8.dp))
//            JobStatsChip()
//            Spacer(modifier = Modifier.width(8.dp))
//            JobStatsChip()
//        }
//    }
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
fun JobStatsCard(
    modifier: Modifier = Modifier,

){
    Card(
        modifier = modifier
            .height(145.dp)
            .width(145.dp),
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

@Composable
fun JobStatsApproved(){
    Box(modifier = Modifier.height(155.dp).fillMaxWidth()
        .background(color = Color.Green)) {

    }



}

@Composable
fun JobStatsInProgress(){
    Box(modifier = Modifier.height(155.dp).fillMaxWidth()
        .background(color = Color.Red)) {

    }
}

