package com.njogu.ajirihiringredone.bottomNavigationScreens.AddTasksScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.app_composables.AppText
import com.njogu.ajirihiringredone.models.*
import com.njogu.ajirihiringredone.homescreen.composables.*
import com.njogu.ajirihiringredone.utils.composables.BasicButton
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.utils.ext.basicButton

@SuppressLint("UnrememberedMutableState")
@Composable
fun TaskBudgetPage(){
    val scrollState = rememberScrollState()
    val totalTaskAmount  = remember{
        mutableStateOf(TextFieldValue())
    }
    var selectedPaymentChip: PaymentChipModel? by remember{
        mutableStateOf(PaymentChipModel.MPESA)
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        AppText(
            text = "Please enter the tasks total amount",
            fontSize = 18.sp,
            fontWeight = FontWeight.W600
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            label = {
                Text(text = "Total Amount")
            },
            value = totalTaskAmount.value,
            onValueChange = {
                totalTaskAmount.value = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        BasicButton(text = R.string.save, modifier = Modifier.basicButton(), action = {})

        Spacer(modifier = Modifier.height(30.dp))
        Divider(thickness = 1.dp, color = Color.Black)
        Spacer(modifier = Modifier.height(30.dp))
        Text("Task summary will be displayed here")


//        Spacer(modifier = Modifier.height(10.dp))
//
//        AppText(
//            text = "Total Price", fontSize = 22.sp, fontWeight = FontWeight.W600
//        )
//        AppText(text = "sh 2500", fontSize = 22.sp, fontWeight = FontWeight.W600)
//        AppText(text = "Select Payment Method", fontSize = 20.sp, fontWeight = FontWeight.W500)
////        PaymentChipCard(
////            name = "Mpesa",
////            isSelected = true,
////            onSelectedChange = {}
////        )
//        selectedPaymentChip?.let {
//            PaymentChipGroup(
//                paymentChips = getAllPaymentChips(),
//                selectedPaymentChip = selectedPaymentChip!!,
//                onSelectedPaymentChip = {
//                    selectedPaymentChip = getSinglePaymentChip(it)
//                }
//            )
//        }
//
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        if (selectedPaymentChip?.name == PaymentChipModel.MPESA.name){
//            PayWithMpesa()
//        }else if(selectedPaymentChip?.name == PaymentChipModel.CREDIT.name){
//            PayWithCreditCard()
//        }else if (selectedPaymentChip?.name == PaymentChipModel.WALLET.name){
//            PayFromWallet()
//        }
//        Spacer(modifier = Modifier.height(20.dp))

    }
}




