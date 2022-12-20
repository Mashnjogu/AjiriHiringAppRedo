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

    fun saveUserDetails(email: String, userName: String, password: String){
        if(email.isEmpty() || userName.isEmpty() || password.isEmpty()){
            throw Exception("All fields must be filled")
        }else{
            SignUpModel(email = email, userName = userName, password= password)
        }

    }

    fun confirmPassword(){
        if(passwordSignUp.value != confirmPasswordSignUp.value){
            Log.d("Sign Up","Passwords do not match")
        }
    }


}