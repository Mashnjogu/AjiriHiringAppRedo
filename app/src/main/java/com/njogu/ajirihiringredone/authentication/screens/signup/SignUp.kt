package com.njogu.ajirihiringredone.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.authentication.screens.signup.SignUpViewModel
import com.njogu.ajirihiringredone.app_composables.CustomTopAppBar
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.utils.composables.*


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

        BasicTextButton(R.string.account_ready, Modifier.align(Alignment.BottomCenter).padding(35.dp)) {
            navController.navigate(Routes.Login.route)
        }
    }
    Column(modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val uiState by signUpViewModel.uiState

        Spacer(modifier = Modifier.height(80.dp))
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

        Spacer(modifier = modifier.height(40.dp))
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

