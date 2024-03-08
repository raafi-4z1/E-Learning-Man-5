package com.example.e_learningman5.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.core.components.Utils.gradientColorList

@Composable
fun GradientButtonComponent(
    nameButton: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(
        topStart = 30.dp,
        bottomEnd = 30.dp
    ),
    gradientColors: List<Color> = gradientColorList(),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
