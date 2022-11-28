package com.njogu.ajirihiringredone.taskcategoriesandinfo.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.njogu.ajirihiringredone.models.PaymentChipModel
import com.njogu.ajirihiringredone.models.getAllPaymentChips


@Composable
fun PaymentChip(
    name: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    onSelectedPaymentChip: (String) -> Unit
    ){


}

@Composable
fun PaymentChipCard(){
    Card(
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.padding(15.dp)){
            Row {
                Text(text = "Mpesa")
                Canvas(modifier = Modifier.height(23.dp)){
                    drawCircle(color = Color.Black, radius = 12f)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentChipPreview(){
    PaymentChipCard()
}

@Composable
fun PaymentChipGroup(
    paymentChips: List<PaymentChipModel> = getAllPaymentChips(),
    selectedPaymentChip: PaymentChipModel? = null,
    onSelectedPaymentChip: (String) -> Unit
){

}



