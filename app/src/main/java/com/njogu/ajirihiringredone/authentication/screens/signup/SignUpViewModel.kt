package com.njogu.ajirihiringredone.authentication.screens.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.authentication.AjiriViewModel
import com.njogu.ajirihiringredone.models.service.AccountService
import com.njogu.ajirihiringredone.models.service.LogService
import com.njogu.ajirihiringredone.navigation.Routes
import com.njogu.ajirihiringredone.utils.isValidEmail
import com.njogu.ajirihiringredone.utils.passwordMatches
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val  accountService: AccountService,
    logService: LogService
): AjiriViewModel(logService) {

    var uiState = mutableStateOf(SignUpUiState())
    private set

    private val userName
    get() = uiState.value.userName

    private val email
    get() = uiState.value.email

    private val password
    get() = uiState.value.password

//    private val repeatPassword
//    get() = uiState.value.repeatPassword

    fun onEmailChange(newEmail: String){
        uiState.value = uiState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword: String){
        uiState.value = uiState.value.copy(password = newPassword)
    }

    fun onUserNameChange(newUserName: String){
        uiState.value = uiState.value.copy(userName = newUserName)
    }

    fun onRepeatPasswordChange(repeatPassword: String){
        uiState.value = uiState.value.copy(repeatPassword = repeatPassword)
    }

    fun onSignUpClick(navController: NavHostController){
        if (!email.isValidEmail()){
            SnackbarManager.showMessage(R.string.email_error)
            return
        }

        if (password.isBlank()){
            SnackbarManager.showMessage(R.string.empty_password_error)
            return
        }

        if (!password.passwordMatches(uiState.value.repeatPassword)){
            SnackbarManager.showMessage(R.string.password_match_error)
            return
        }

        launchCatching {
            accountService.signUpAccount(email, password)
           navController.navigate(Routes.Login.route)
        }
    }

}