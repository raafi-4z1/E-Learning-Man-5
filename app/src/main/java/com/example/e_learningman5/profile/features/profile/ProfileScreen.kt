package com.example.e_learningman5.profile.features.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.e_learningman5.core.features.navigation.components.Utils

@Composable
fun ProfileScreen(
    onClickUpProfile: () -> Unit,
    onClickUpPass: () -> Unit,
    onClickExit: () -> Unit
) {
    val openDialog = remember {
        mutableStateOf(false)
    }

    if (openDialog.value)
        Utils.AlertDialogComponent(
            titleText = "Konfirmasi diperlukan",
            descriptionText = "Apakah kamu ingin keluar?",
            confirmButtonText = "Keluar",
            dismissButtonText = "Batal",
            openDialog = openDialog
        ) { onClickExit() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(text = "Profile Screen")
            Button(onClick = { onClickUpProfile() }) {
                Text(text = "Click Edit Profile")
            }
            Button(onClick = { onClickUpPass() }) {
                Text(text = "Click Edit Password")
            }
            Button(onClick = { openDialog.value = true }) {
                Text(text = "Click Logout")
            }
        }
    }
}