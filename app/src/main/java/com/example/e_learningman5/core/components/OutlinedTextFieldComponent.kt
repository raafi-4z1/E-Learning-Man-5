package com.example.e_learningman5.core.components

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
    modifier: Modifier,
    mLines: Int = 1,
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        maxLines = mLines,
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
