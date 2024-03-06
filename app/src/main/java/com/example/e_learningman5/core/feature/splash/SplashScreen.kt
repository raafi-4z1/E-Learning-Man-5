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
import kotlinx.coroutines.delay

@Composable
fun SplashScreenCompose(
    onEvent: () -> Unit
) {
    val alpha = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true, block = {
        alpha.animateTo(
            1f,
            animationSpec = tween(1500)
        )
        delay(3000)
        onEvent()
    })
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
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
