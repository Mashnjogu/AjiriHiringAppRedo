package com.njogu.ajirihiringredone.authentication.screens.signIn

import android.accounts.Account
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.njogu.ajirihiringredone.R
import com.njogu.ajirihiringredone.authentication.AjiriViewModel
import com.njogu.ajirihiringredone.models.service.AccountService
import com.njogu.ajirihiringredone.models.service.LogService
import com.njogu.ajirihiringredone.utils.isValidEmail
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val  accountService: AccountService,
    logService: LogService
): AjiriViewModel(logService){

    var uiState = mutableStateOf(SignInUIState())
    private set

    private val email
    get() = uiState.value.email
    private val password
    get() = uiState.value.password

    fun onEmailChange(newEmail: String){
        uiState.value = uiState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword: String){
        uiState.value = uiState.value.copy(password = newPassword)
    }

    fun onSignInClick(){
        if (!email.isValidEmail()){
            SnackbarManager.showMessage(R.string.email_error)
            return
        }

        if (password.isBlank()){
            SnackbarManager.showMessage(R.string.empty_password_error)
            return
        }

        launchCatching {
            accountService.authenticate(email, password)
        }

    }

    fun onForgotPasswordClick() {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(R.string.email_error)
            return
        }

        launchCatching {
            accountService.sendRecoveryEmail(email)
            SnackbarManager.showMessage(R.string.recovery_email_sent)
        }
    }
}