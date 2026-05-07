package com.kira.health.app.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.kira.health.R
import com.kira.health.app.domain.models.Contact
import com.kira.health.app.domain.models.User
import com.kira.health.app.presentation.common.State
import com.kira.health.app.presentation.screens.home.components.ContactsList

@Composable
fun HomeScreen(
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val userState by viewModel.userState.collectAsState()
    val contactsState by viewModel.contactsState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.home_title),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            UserInfoSection(userState = userState)

            Button(onClick = onLogoutClick) {
                Text(text = stringResource(id = R.string.home_logout_button))
            }

            Button(
                onClick = {
                    FirebaseCrashlytics.getInstance().log("Test Crashlytics button tapped")
                    throw RuntimeException("Test Crash - Crashlytics")
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.home_test_crashlytics))
            }
        }

        Text(
            text = stringResource(id = R.string.home_contacts_title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )

        ContactsSection(
            contactsState = contactsState,
            onRetryClick = { viewModel.fetchContacts() }
        )
    }
}

@Composable
private fun UserInfoSection(userState: State<User>) {
    val user = userState.data

    when {
        user != null -> {
            Text(
                text = "Welcome, ${user.name.orEmpty()}!",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = user.email.orEmpty(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }

        !userState.errorMessage.isNullOrEmpty() -> Text(
            text = userState.errorMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        else -> Text(
            text = "Loading user information...",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Composable
private fun ColumnScope.ContactsSection(
    contactsState: State<List<Contact>>,
    onRetryClick: () -> Unit
) {
    val contacts = contactsState.data.orEmpty()

    if (!contactsState.errorMessage.isNullOrEmpty()) {
        Text(
            text = contactsState.errorMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(
            onClick = onRetryClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.home_contacts_retry))
        }
    }

    ContactsList(
        isLoading = contactsState.isLoading,
        contacts = contacts,
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
    )
}
