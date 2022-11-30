package com.njogu.ajirihiringredone.bottomNavScreens.AddTasksScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.njogu.ajirihiringredone.models.*
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.JobStatChipGroup
import com.njogu.ajirihiringredone.taskcategoriesandinfo.components.PaymentChipGroup

@Composable
fun TaskBudgetPage(){
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
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text("Please enter the tasks total amount")
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
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Divider(thickness = 1.dp, color = Color.Black)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Choose your preffered payment method")
//        PaymentChipCard(
//            name = "Mpesa",
//            isSelected = true,
//            onSelectedChange = {}
//        )
        PaymentChipGroup(
            paymentChips = getAllPaymentChips(),
            selectedPaymentChip = selectedPaymentChip,
            onSelectedPaymentChip = {
                selectedPaymentChip = getSinglePaymentChip(it)
            }
        )


//        when(){}
    }
}
