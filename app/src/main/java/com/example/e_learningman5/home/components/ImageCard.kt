package com.example.e_learningman5.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@ExperimentalMaterial3Api
@Composable
fun ImageCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    idPhoto: Int = (0..9).random(),
    isEnabledAssistChip: Boolean = false,
    onEvent: () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = "https://picsum.photos/id/$idPhoto/300/200"
            ),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (isEnabledAssistChip)
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    mainAxisSpacing = 8.dp,
                    mainAxisSize = SizeMode.Wrap
                ) {
                    AssistChip(
                        onClick = { onEvent() },
                        colors = AssistChipDefaults.assistChipColors(
                            leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "More Info"
                            )
                        },
                        label = {
                            Text(text = "More Info")
                        }
                    )
                    AssistChip(
                        onClick = {  },
                        colors = AssistChipDefaults.assistChipColors(
                            leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Share,
                                contentDescription = "Share Content"
                            )
                        },
                        label = {
                            Text(text = "Share Content")
                        }
                    )
                }
        }
    }
}