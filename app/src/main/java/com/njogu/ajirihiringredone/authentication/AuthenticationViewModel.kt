package com.njogu.ajirihiringredone.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njogu.ajirihiringredone.models.service.LogService
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarManager
import com.njogu.ajirihiringredone.utils.snackbar.SnackbarMessage.Companion.toSnackbarMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class AjiriViewModel(private val logService: LogService): ViewModel(){
    fun launchCatching(snackbar: Boolean = true, block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                if (snackbar) {
                    SnackbarManager.showMessage(throwable.toSnackbarMessage())
                }
                logService.logNonFatalCrash(throwable)
            },
            block = block
        )
}