package com.example.e_learningman5.main.feature.profile.screen.update

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.core.components.GradientButtonComponent
import com.example.e_learningman5.core.components.OutlinedPasswordTextFieldComponent

@Composable
fun UpdatePasswordScreen(onClick: () -> Unit) {
    var oldPassword by rememberSaveable { mutableStateOf("") }
    var newPassword by rememberSaveable { mutableStateOf("") }
    var repeatNewPassword by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier.padding(top = 65.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedPasswordTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                titleTextField = "Enter Old Password",
                value = oldPassword,
                onValueChange = { oldPassword = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password
                )
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedPasswordTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                titleTextField = "Enter New Password",
                value = newPassword,
                onValueChange = { newPassword = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                )
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedPasswordTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                titleTextField = "Enter Repeat New Password",
                value = repeatNewPassword,
                onValueChange = { repeatNewPassword = it },
                isIconPasswordHidden = false,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password
                )
            )
            Spacer(modifier = Modifier.height(25.dp))

            GradientButtonComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                nameButton = "Update Password"
            ) { onClick() }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}
