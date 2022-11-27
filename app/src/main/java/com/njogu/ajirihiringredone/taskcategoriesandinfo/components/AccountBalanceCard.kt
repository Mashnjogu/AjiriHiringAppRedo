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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.ui.theme.c1


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
                                Text(
                                    text = heading1,
                                    fontWeight = FontWeight.W600,
                                    letterSpacing = 1.sp,

                                )
            Text(
                text = heading2,
                fontWeight = FontWeight.W600,
                letterSpacing = 1.sp
            )
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
                Text(
                    text = "sh ",
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.sp,
                    fontSize = 17.sp
                )
                Text(
                    text = amount,
                    fontWeight = FontWeight.W600,
                    letterSpacing = 2.sp,
                    fontSize = 17.sp
                )
            }
            }
        }

    }
}