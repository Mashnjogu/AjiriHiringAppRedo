package com.njogu.ajirihiringredone.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.authentication.screens.signIn.SignInViewModel
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.utils.composables.BasicTextButton
import com.njogu.ajirihiringredone.utils.composables.EmailField
import com.njogu.ajirihiringredone.utils.composables.PasswordField
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.utils.ext.textButton

@Composable
fun SignIn(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController
){

    val signInViewModel = hiltViewModel<SignInViewModel>()

    Box(modifier = modifier.fillMaxSize()){

        BasicTextButton(R.string.create_account, Modifier.textButton()) {
            signInViewModel.onForgotPasswordClick()
        }

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
        val uiState by signInViewModel.uiState

        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
        Spacer(modifier = modifier.height(20.dp))

        EmailField(value = uiState.email, onNewValue = signInViewModel::onEmailChange)


        Spacer(modifier = modifier.height(20.dp))

        PasswordField(value = uiState.password, onNewValue = signInViewModel::onPasswordChange)

        Spacer(modifier = modifier.height(20.dp))
        Box(modifier = modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
            Button(
                onClick = {
                          signInViewModel.onSignInClick(navController)
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
        BasicTextButton(R.string.forgot_password, Modifier.textButton()) {
            signInViewModel.onForgotPasswordClick()
        }

    }
}