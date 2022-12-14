package com.njogu.ajirihiringredone.authentication

data class AuthenticationTextFieldsState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean  = true
)