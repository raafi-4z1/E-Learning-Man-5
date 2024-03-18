package com.example.e_learningman5.core.feature.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.R
import com.example.e_learningman5.login.domain.model.ValidationEvent
import com.example.e_learningman5.login.feature.LoginViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreenCompose(
    viewModel: LoginViewModel,
    onSession: () -> Unit,
    onEvent: (String?) -> Unit
) {
    val alpha = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f, animationSpec = tween(1500))
        viewModel.validationEvents.collect { event ->
            when (event) {
                // pernah login kurang dari 5 hari
                is ValidationEvent.Success -> onSession()

                // lebih dari 5 hari
                is ValidationEvent.Error -> {
                    delay(3000)
                    if (event.message == "null") {
                        // tidak pernah login / keluar
                        onEvent("0")
                    } else onEvent(event.message)
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(165.dp)
                .alpha(alpha.value),
            painter = painterResource(id = R.drawable.man5),
            contentDescription = "man5"
        )
    }
}
