package com.example.e_learningman5.main.feature.profile.screen.update

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.R
import com.example.e_learningman5.core.components.GradientButtonComponent
import com.example.e_learningman5.core.components.OutlinedTextFieldComponent

@Composable
fun UpdateProfileScreen(onClick: () -> Unit) {
    var name by rememberSaveable { mutableStateOf("") }
    var cellPhone by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier.padding(top = 65.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .size(175.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .clickable { /** UPDATE PICTURE */ },
                imageVector = ImageVector.vectorResource(id = R.drawable.profile_user),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                titleTextField = "Enter Student's name",
                value = name,
                onValueChange = { name = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                titleTextField = "Enter Student Cell Phone",
                value = cellPhone,
                onValueChange = { cellPhone = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                )
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextFieldComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                titleTextField = "Enter Address",
                value = address,
                mLines = 3,
                onValueChange = { address = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )
            Spacer(modifier = Modifier.height(25.dp))

            GradientButtonComponent(
                modifier = Modifier.fillMaxWidth(0.88f),
                nameButton = "Update Profile"
            ) { onClick() }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}
