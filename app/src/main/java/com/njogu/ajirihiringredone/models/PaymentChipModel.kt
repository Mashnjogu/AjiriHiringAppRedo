package com.njogu.ajirihiringredone.models

enum class PaymentChipModel(val value: String){
    MPESA("Mpesa"),
    CREDIT("Credit"),
    PAYPAL("Paypal"),
    WALLET("Wallet")
}

fun getAllPaymentChips(): List<PaymentChipModel>{
    return listOf(PaymentChipModel.MPESA, PaymentChipModel.CREDIT,
        PaymentChipModel.PAYPAL, PaymentChipModel.WALLET)
}

fun getSinglePaymentChip(value: String): PaymentChipModel{
    val map = PaymentChipModel.values().associateBy(PaymentChipModel::value)
    return map[value]!!
}

