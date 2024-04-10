package com.example.e_learningman5.main.feature.home.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.e_learningman5.main.feature.home.components.HomeCardComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClick: (String) -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    LazyVerticalGrid(columns = GridCells.Adaptive(300.dp), content = {
        items(20) { item ->
            HomeCardComponent(
                title = "Bacon ipsum",
                idPhoto = item,
                description = "Bacon ipsum dolor amet pork shankle beef andouille ball tip. Meatball corned beef swine, strip steak bacon jerky doner tongue biltong pork loin drumstick sausage hamburger burgdoggen.",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        onClick(item.toString())
                    },
                isEnabledAssistChip = true,
                onEvent = { isSheetOpen = true }
            )
        }
    })

    if (isSheetOpen)
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
                sheetState.hasExpandedState
            },
            scrimColor = Color(0x00FFFFFF)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = "https://picsum.photos/seed/${(0..9).random()}/500/400"
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(5f / 4f)
            )
        }
}
