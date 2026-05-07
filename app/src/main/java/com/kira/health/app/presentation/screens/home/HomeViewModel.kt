package com.kira.health.app.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kira.health.app.data.repositories.AuthRepository
import com.kira.health.app.data.repositories.ContactRepository
import com.kira.health.app.data.repositories.UserRepository
import com.kira.health.app.domain.models.Contact
import com.kira.health.app.domain.models.User
import com.kira.health.app.presentation.common.State
import com.kira.health.app.presentation.common.toState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
    private val contactRepository: ContactRepository
) : ViewModel() {

    private val _userState = MutableStateFlow(State<User>())
    val userState: StateFlow<State<User>> = _userState

    private val _contactsState = MutableStateFlow(State<List<Contact>>())
    val contactsState: StateFlow<State<List<Contact>>> = _contactsState

    init {
        getUser()
        fetchContacts()
    }

    fun getUser() {
        viewModelScope.launch {
            _userState.value = State(isLoading = true)
            _userState.value = userRepository.getUser().toState()
        }
    }

    fun fetchContacts() {
        viewModelScope.launch {
            _contactsState.value = State(isLoading = true)
            _contactsState.value = contactRepository.fetchContacts().toState()
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
        }
    }
}
