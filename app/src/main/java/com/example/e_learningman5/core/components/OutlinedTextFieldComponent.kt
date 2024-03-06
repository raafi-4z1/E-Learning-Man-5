package com.example.e_learningman5.core.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldComponent(
    titleTextField: String,
    value: String,
    valueError: String? = null,
    keyboardOptions: KeyboardOptions,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier.fillMaxWidth(0.8f),
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
        label = {
            Text(
                titleTextField,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium
            )
        },
        isError = valueError != null,
        placeholder = { Text(text = titleTextField) },
        keyboardOptions = keyboardOptions,
        singleLine = true,
        modifier = modifier
    )
    if (valueError != null)
        Text(
            text = valueError,
            color = MaterialTheme.colorScheme.error,
            modifier = modifier
        )
}
