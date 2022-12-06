package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.components.AppText
import com.njogu.ajirihiringredone.components.AppTextField

@Composable
fun PayWithMpesa(){

}

@Composable
fun PayWithCreditCard(){
    val image = painterResource(
        id = com.njogu.ajirihiringredone.R.drawable.icons8_mastercard_logo_48
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        AppText(
            text = "Card number",
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
        )
        Spacer(Modifier.height(8.dp))
        AppTextField(
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Image(
                    modifier = Modifier.size(45.dp).padding(start = 8.dp),
                painter = image,
                contentDescription = "MasterCardIcon"
            )
                          },
            text = "",
            placeholder = "123 456 789"
        )
        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column {

                AppText(
                    text = "Valid Until",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                )
                Spacer(modifier = Modifier.height(8.dp))
                AppTextField(
                    modifier = Modifier.width(170.dp),
                    text = "",
                    placeholder = "Month/Year")
            }
            Spacer(modifier = Modifier.width(22.dp))
            Column() {

                AppText(
                    text = "CVV",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                )
                Spacer(modifier = Modifier.height(8.dp))
                AppTextField(
                    modifier = Modifier.width(170.dp),
                    text = "",
                    placeholder = "****"
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        AppText(
            text = "Card Holder",
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
        )
        Spacer(Modifier.height(8.dp))
        AppTextField(text = "", placeholder = "Your name and surname")
        Spacer(Modifier.height(12.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            AppText(
                text = "Save card data for future reference",
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
            )
            Switch(checked = true, onCheckedChange = {})
        }
        Spacer(Modifier.height(12.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Proceed to confirm", fontSize = 18.sp)
            }
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