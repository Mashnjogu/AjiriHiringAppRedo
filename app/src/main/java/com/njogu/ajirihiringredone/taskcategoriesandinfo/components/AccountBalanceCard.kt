package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AccountBalanceCard(
    modifier: Modifier = Modifier,
    heading1: String,
    heading2: String,
    amount: String
){
    Card(
        modifier = modifier.height(195.dp).width(157.dp),
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(8.dp)
                ){
            Text(text = heading1)
            Text(text = heading2)
            Spacer(modifier = modifier.height(25.dp))
            Row() {
                Text(text = "sh ")
                Text(text = amount)
            }
        }
    }
}