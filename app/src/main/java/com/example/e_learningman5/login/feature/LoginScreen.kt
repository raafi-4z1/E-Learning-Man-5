package com.example.e_learningman5.login.feature

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.R
import com.example.e_learningman5.core.components.GradientButtonComponent
import com.example.e_learningman5.core.components.OutlinedPasswordTextFieldComponent
import com.example.e_learningman5.core.components.OutlinedTextFieldComponent
import com.example.e_learningman5.login.domain.model.RegistrationFormEvent
import com.example.e_learningman5.login.domain.model.ValidationEvent

/**
 *
 * Login Component Design, by: https://github.com/BoltUIX/Compose-User-Registration-Login-Reset-password-pages-with-UI-UX
 * */
@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    paramSession: String,
    onClick: () -> Unit
) {
    val state = viewModel.state
    val context = LocalContext.current

    if (paramSession != "0")
        Toast.makeText(context, paramSession, Toast.LENGTH_LONG).show()

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is ValidationEvent.Success -> onClick()

                is ValidationEvent.Error -> Toast.makeText(
                    context,
                    event.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(26.dp))
            Image(
                painter = painterResource(id = R.drawable.man5),
                contentDescription = "Logo MAN 5",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(165.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Sign In",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.8f),
                titleTextField = "Email Address",
                value = state.email,
                valueError = state.emailError,
                onValueChange = { viewModel.onEvent(RegistrationFormEvent.EmailChanged(it)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                )
            )
            Spacer(modifier = Modifier.height(3.dp))

            OutlinedPasswordTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.8f),
                titleTextField = "Enter Password",
                value = state.password,
                valueError = state.passwordError,
                onValueChange = { viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                )
            )
            Spacer(modifier = Modifier.height(45.dp))

            GradientButtonComponent(
                modifier = Modifier.fillMaxWidth(0.8f),
                nameButton = "Login",
                onClick = { viewModel.onEvent(RegistrationFormEvent.Submit) }
            )
            Spacer(modifier = Modifier.height(45.dp))
        }
    }
}
