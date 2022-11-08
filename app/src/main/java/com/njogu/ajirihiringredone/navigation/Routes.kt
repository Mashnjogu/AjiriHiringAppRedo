package com.njogu.ajirihiringredone.navigation

sealed class Routes(val route: String){
    object Login: Routes("Login")
    object SignUp: Routes("SignUp")
    object ForgotPassword: Routes("Forgot Password")
    object HomeScreen: Routes("HomeScreen")
}