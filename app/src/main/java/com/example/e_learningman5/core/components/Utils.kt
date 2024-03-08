package com.example.e_learningman5.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_learningman5.core.feature.navigation.route.Routes

object Utils {
    @Composable
    fun AlertDialogComponent(
        titleText: String,
        descriptionText: String,
        confirmButtonText: String,
        dismissButtonText: String,
        openDialog: MutableState<Boolean>,
        onClick: () -> Unit
    ) {
        AlertDialog(
            shape = RoundedCornerShape(20.dp),
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = titleText, fontWeight = FontWeight.Bold) },
            text = { Text(text = descriptionText) },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        onClick()
                    },
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                ) {
                    Text(
                        text = confirmButtonText,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                    )

                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { openDialog.value = false },
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(50),
                ) {
                    Text(
                        text = dismissButtonText,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                        fontSize = 12.sp
                    )
                }
            }
        )
    }

    @Composable
    fun gradientColorList(): List<Color> = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.outline
    )

    fun myListScreen() = listOf(
        BottomItem(
            title = Routes.HomeScreen.route,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ), BottomItem(
            title = Routes.ProfileScreen.route,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )

    data class BottomItem(
        val title: String, val selectedIcon: ImageVector, val unselectedIcon: ImageVector
    )
}
