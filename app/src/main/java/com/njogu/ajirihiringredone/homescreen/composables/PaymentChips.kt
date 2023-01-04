package com.njogu.ajirihiringredone.homescreen.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njogu.ajirihiringredone.models.PaymentChipModel
import com.njogu.ajirihiringredone.models.getAllPaymentChips
import com.njogu.ajirihiringredone.ui.theme.Malibu
import com.njogu.ajirihiringredone.ui.theme.Purple200


@Composable
fun PaymentChipCard(
    name:  String = "MPESA",
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onSelectedChange: (String) -> Unit
){
    Card(
        modifier = modifier.toggleable(
            value = isSelected,
            onValueChange = {
                onSelectedChange(name)

            }
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp,
        backgroundColor = if (isSelected) Purple200 else Malibu
    ) {
        Box(modifier = modifier.padding(15.dp)){
            Row (

            ){
                Text(
                    text = name,
                    color = if(isSelected) Color.White else Color.Black,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = if(isSelected)18.sp else 16.sp
                )
                Spacer(modifier = modifier.width(8.dp))
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = modifier
                        .height(25.dp)
                        .width(25.dp),
                    shape = androidx.compose.foundation.shape.CircleShape,
                    border = BorderStroke(1.dp, Color.Black),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "")
                }
                }
            }
        }
    }

@Composable
fun PaymentChipGroup(
    paymentChips: List<PaymentChipModel> = getAllPaymentChips(),
    selectedPaymentChip: PaymentChipModel,
    onSelectedPaymentChip: (String) -> Unit
){
    Column(modifier = Modifier.padding(8.dp)){
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
            items(paymentChips){
                PaymentChipCard(
                    name = it.value,
                    onSelectedChange = {
                        onSelectedPaymentChip(it)
                                       },
                    isSelected = selectedPaymentChip == it
                )
            }
        }
    }
}





