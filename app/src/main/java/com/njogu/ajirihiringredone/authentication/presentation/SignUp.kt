package com.njogu.ajirihiringredone.authentication

import android.graphics.fonts.FontFamily.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons.Default
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontFamily.Companion.Default
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.components.CustomTopAppBar
import com.njogu.ajirihiringredone.navigation.Routes

@Composable
fun SignUp(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthenticationViewModel
){
    Box(modifier = modifier.fillMaxSize()) {
        ScaffoldWithTopBar(navController = navController)
    }

    Box(modifier = modifier.fillMaxSize()){

        ClickableText(
            text = AnnotatedString("Already have an account ?"),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {
                navController.navigate(Routes.Login.route)
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
        val userName = remember{
            mutableStateOf(TextFieldValue())
        }
        val password  = remember{
            mutableStateOf(TextFieldValue())
        }
        val confirmPassword = remember {
            mutableStateOf(TextFieldValue())
        }

        Text(text = "SignUp", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            label = { Text(text = "Email")},
            value = authViewModel.emailSignUp.value, onValueChange = {authViewModel.emailSignUp.value = it}
        )
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            label = { Text(text = "UserName")},
            value = authViewModel.userNameSignUp.value, onValueChange = {
                authViewModel.userNameSignUp.value = it
            }
        )
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password")},
            value = authViewModel.passwordSignUp.value, onValueChange = {
                authViewModel.passwordSignUp.value
                                                                        },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            label = { Text(text = " Confirm Password")},
            value = authViewModel.confirmPasswordSignUp.value, onValueChange = {
                authViewModel.confirmPasswordSignUp.value = it
                                                                               },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = modifier.height(20.dp))
        Box(modifier = modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
            Button(
                onClick = {
                          authViewModel.confirmPassword()
                },
                shape = RoundedCornerShape(50.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
        Spacer(modifier = modifier.height(20.dp))

    }

}

@Composable
fun ScaffoldWithTopBar(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopAppBar(navController = navController, title = "Sign Up", showBackIcon = true)
        },
        content = { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){


            }
        }
    )
}
