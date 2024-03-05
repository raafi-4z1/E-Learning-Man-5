package com.example.e_learningman5.core.feature.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    titleTopAppBar: String,
    isEnableNavIcon: Boolean,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            if (isEnableNavIcon)
                IconButton(
                    onClick = { onClick() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
        },
        title = {
            Text(
                text = titleTopAppBar,
                fontSize = 20.sp
            )
        },
        modifier = Modifier.shadow(2.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}