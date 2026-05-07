package com.kira.health.app.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kira.health.app.data.repositories.AuthRepository
import com.kira.health.app.presentation.common.State
import com.kira.health.app.presentation.common.toState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow(State<String>())
    val loginState: StateFlow<State<String>> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = State(isLoading = true)
            _loginState.value = authRepository.login(email, password).toState()
        }
    }
}
