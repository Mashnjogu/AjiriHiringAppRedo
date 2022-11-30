package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.njogu.ajirihiringredone.components.AppTextField

@Composable
fun PayWithMpesa(){

}

@Composable
fun PayWithCreditCard(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Card Number")
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            text = "",
            placeholder = "123 456 789"
        )
        Row() {
            Text(text = "Valid Until")
            Text(text = "CVV")
        }
        Row() {
            AppTextField(
                text = "",
                placeholder = "Month/Year")
            AppTextField(
                text = "",
                placeholder = "567"
            )
        }
       
        Text(text = "Card Holder")
        AppTextField(text = "", placeholder = "Your name and surname")
        Row {
            Text(text = "Save card data for future reference")
            Switch(checked = true, onCheckedChange = {})
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PayWithCreditPreview(){
    PayWithCreditCard()
}

@Composable
fun PayWithPayPal(){

}

@Composable
fun PayFromWallet(){

}