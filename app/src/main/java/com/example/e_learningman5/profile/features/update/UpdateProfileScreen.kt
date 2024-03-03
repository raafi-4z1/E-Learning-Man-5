package com.example.e_learningman5.profile.features.update

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun UpdateProfileScreen(
    onClick: (destination: String) -> Unit
) {
    val destination = "Edit Profile"

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(text = "Edite Profile Screen")
            Button(onClick = { onClick(destination) }) {
                Text(text = "Back")
            }
        }
    }
}