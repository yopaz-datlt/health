package com.kira.health.app.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kira.health.app.domain.models.Contact

@Composable
fun ContactsList(
    isLoading: Boolean,
    contacts: List<Contact>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(ContactItemDefaults.ItemSpacing),
        modifier = modifier.fillMaxWidth()
    ) {
        if (isLoading) {
            items(ContactItemDefaults.SKELETON_COUNT) {
                ContactSkeletonItem(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        } else {
            items(contacts) { contact ->
                ContactItem(
                    contact = contact,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
