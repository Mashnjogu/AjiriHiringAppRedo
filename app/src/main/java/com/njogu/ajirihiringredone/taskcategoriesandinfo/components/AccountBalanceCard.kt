package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import com.njogu.ajirihiringredone.ui.theme.c1
import com.njogu.ajirihiringredone.ui.theme.florecentBlue

@Composable
fun AccountBalanceCard(
    modifier: Modifier = Modifier,
    heading1: String,
    heading2: String,
    amount: String
){
    Card(
        modifier = modifier
            .height(195.dp)
            .width(157.dp),
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column (modifier = Modifier.fillMaxSize()){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                c1,
                                Color.White
                            )
                        )
                    )
                    .weight(1f)
                    .padding(8.dp),
                contentAlignment = Alignment.TopCenter
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(8.dp)
                ){
                                Text(text = heading1)
            Text(text = heading2)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .weight(1f)
                    .padding(top = 8.dp),
                contentAlignment = Alignment.TopCenter
            ){
                Row(
                    modifier = modifier.padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                Text(text = "sh ")
                Text(text = amount)
            }
            }
        }
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = modifier.padding(8.dp)
//                ){
//
//
//            Text(text = heading1)
//            Text(text = heading2)
//            Spacer(modifier = modifier.height(25.dp))
//            Row() {
//                Text(text = "sh ")
//                Text(text = amount)
//            }
//        }
    }
}