package com.njogu.ajirihiringredone.homescreen.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.app_composables.AppText
import com.njogu.ajirihiringredone.app_composables.AppTextField

@Composable
fun PayWithMpesa(){
    val image = painterResource(
        id = com.njogu.ajirihiringredone.R.drawable.mpesaicon
    )

    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ){
        Box(modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ){
                Row (

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painter = image, contentDescription = "")
                    Spacer(modifier = Modifier.width(18.dp))
                    AppText(
                        text = "Enter Amount and Number",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600
                    )
                }

                AppText(text = "Amount", fontSize = 16.sp, fontWeight = FontWeight.W600)
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .border(
                                1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                            )

                    ) {

                        Row(modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "sh 2500",
                            )

//                    Icon(
//                        imageVector = Icons.Default.DateRange,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(20.dp, 20.dp)
//                        ,
//                        tint = MaterialTheme.colors.onSurface
//                    )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                AppText(
                    text = "Phone Number",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600
                )
                Spacer(modifier = Modifier.height(8.dp))
                AppTextField(text = "", placeholder = "07 .. ..")
                Spacer(modifier = Modifier.height(15.dp))
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
                    Button(
                        onClick = {

                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Proceed ", fontSize = 18.sp)
                    }
                }
            }
        }
    }



}

@Composable
fun PayWithCreditCard(){
    val image = painterResource(
        id = com.njogu.ajirihiringredone.R.drawable.icons8_mastercard_logo_48
    )

    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Box(modifier = Modifier
            .height(450.dp)
            .fillMaxWidth()) {
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
                            modifier = Modifier
                                .size(45.dp)
                                .padding(start = 8.dp),
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
    }



}

@Composable
fun PayWithPayPal(){

}

@Composable
@Preview(showBackground = true)
fun PayWithCreditPreview(){
    PayWithCreditCard()
}



@Composable
fun PayFromWallet() {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Box(modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AppText(
                    text = "WALLET BALANCE",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,

                    )
                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    AppText(text = "sh", fontSize = 18.sp, fontWeight = FontWeight.W400)
                    Spacer(modifier = Modifier.width(10.dp))
                    AppText(text = "7800", fontSize = 24.sp, fontWeight = FontWeight.W500)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = "Reduction Amount: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        text = "- sh 2500",
                        color = Color.Red,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )

                }
                Spacer(modifier = Modifier.height(18.dp))
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
                    Button(
                        onClick = {

                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Withdraw from Wallet",
                            fontSize = 16.sp
                        )
                    }
                }
            }

        }
    }

}