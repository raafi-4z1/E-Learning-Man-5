package com.example.e_learningman5.home.feature.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.home.components.ImageCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    LazyVerticalGrid(columns = GridCells.Adaptive(300.dp), content = {
        items(3) {
            ImageCard(
                title = "Bacon ipsum",
                description = "Bacon ipsum dolor amet pork shankle beef andouille ball tip. Meatball corned beef swine, strip steak bacon jerky...",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { },
                onEvent = { }
            )
        }
    })
}