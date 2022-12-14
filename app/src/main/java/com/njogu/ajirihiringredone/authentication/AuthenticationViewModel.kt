package com.njogu.ajirihiringredone.authentication

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthenticationViewModel: ViewModel() {
    val emailSignUp = mutableStateOf("")
    val userNameSignUp = mutableStateOf("")
    val passwordSignUp = mutableStateOf("")
    val confirmPasswordSignUp = mutableStateOf("")

    fun confirmPassword(){
        if(passwordSignUp.value != confirmPasswordSignUp.value){
            Log.d("Sign Up","Passwords do not match")
        }
    }


}