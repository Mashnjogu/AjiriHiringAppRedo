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
import androidx.compose.runtime.getValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.authentication.screens.signup.SignUpViewModel
import com.njogu.ajirihiringredone.components.CustomTopAppBar
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.utils.composables.BasicField
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.utils.composables.EmailField
import com.njogu.ajirihiringredone.utils.composables.PasswordField
import com.njogu.ajirihiringredone.utils.composables.RepeatPasswordField


@Composable
fun SignUp(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    val signUpViewModel = hiltViewModel<SignUpViewModel>()
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

        val uiState by signUpViewModel.uiState

        Text(text = "SignUp", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
        Spacer(modifier = modifier.height(20.dp))

        Spacer(modifier = modifier.height(20.dp))

        BasicField(text = R.string.user_name, value = uiState.userName, onNewValue = signUpViewModel::onUserNameChange)

        Spacer(modifier = modifier.height(20.dp))

        EmailField(value = uiState.email, onNewValue = signUpViewModel::onEmailChange)

        Spacer(modifier = modifier.height(20.dp))

        PasswordField(value = uiState.password, onNewValue = signUpViewModel::onPasswordChange)


        Spacer(modifier = modifier.height(20.dp))

        RepeatPasswordField(value = uiState.repeatPassword, onNewValue = signUpViewModel::onRepeatPasswordChange)

        Spacer(modifier = modifier.height(20.dp))
        Box(modifier = modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
            Button(
                onClick = {
                          signUpViewModel.onSignUpClick(navController)
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){


            }
        }
    )
}

