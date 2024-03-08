package com.example.e_learningman5.core.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.R

@Composable
fun OutlinedPasswordTextFieldComponent(
    titleTextField: String,
    value: String,
    valueError: String? = null,
    modifier: Modifier,
    keyboardOptions: KeyboardOptions,
    isIconPasswordHidden: Boolean = true,
    onValueChange: (String) -> Unit
) {
    if (isIconPasswordHidden) {
        var passwordHidden by rememberSaveable { mutableStateOf(true) }
        val focusManager = LocalFocusManager.current

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            maxLines = 1,
            shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
            label = {
                Text(
                    text = titleTextField,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                )
            },
            isError = valueError != null,
            keyboardOptions = keyboardOptions,
            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                    Icon(
                        painter = painterResource(
                            id = if (passwordHidden) R.drawable.baseline_visibility_24
                            else R.drawable.baseline_visibility_off_24
                        ),
                        contentDescription = if (passwordHidden) "Show password" else "Hide password"
                    )
                }
            },
            singleLine = true,
            modifier = modifier,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )
    } else {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            maxLines = 1,
            shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
            label = {
                Text(
                    text = titleTextField,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                )
            },
            isError = valueError != null,
            keyboardOptions = keyboardOptions,
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = modifier
        )
    }
    if (valueError != null)
        Text(
            text = valueError,
            color = MaterialTheme.colorScheme.error,
            modifier = modifier
        )
}
