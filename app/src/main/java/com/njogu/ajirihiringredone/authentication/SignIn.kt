package com.njogu.ajirihiringredone.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.navigation.Routes

@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Box(modifier = modifier.fillMaxSize()){
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {
                navController.navigate(Routes.SignUp.route)
            },
            style = TextStyle(color = Color.Blue, fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline
            )
        )
    }
    Column(modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val emailAddress  = remember{
            mutableStateOf(TextFieldValue())
        }
        val password  = remember{
            mutableStateOf(TextFieldValue())
        }

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            label = { Text(text = "Email")},
            value = emailAddress.value, onValueChange = {emailAddress.value = it}
        )
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password")},
            value = password.value, onValueChange = {password.value = it},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = modifier.height(20.dp))
        Box(modifier = modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
            Button(
                onClick = {
                          navController.navigate(Routes.HomeScreen.route)
                },
                shape = RoundedCornerShape(50.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }
        Spacer(modifier = modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("Forgot Password"),
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default
            ),
            onClick = {
                navController.navigate(Routes.ForgotPassword.route)
            }
        )
    }
}