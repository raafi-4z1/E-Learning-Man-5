package com.example.e_learningman5.main.feature.profile.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.e_learningman5.R
import com.example.e_learningman5.core.components.GradientButtonComponent
import com.example.e_learningman5.core.components.Utils.AlertDialogComponent
import com.example.e_learningman5.core.components.Utils.gradientColorList
import com.example.e_learningman5.core.feature.navigation.route.Routes

@Composable
fun ProfileScreen(
    gradientColors: List<Color> = gradientColorList().asReversed(),
    onClick: (String) -> Unit
) {
    val modifierElevatedCard = Modifier.fillMaxWidth(0.88f)
    val modifierSpacer = Modifier.height(15.dp)

    val openDialog = remember {
        mutableStateOf(false)
    }

    if (openDialog.value)
        AlertDialogComponent(
            titleText = "Konfirmasi diperlukan",
            descriptionText = "Apakah kamu ingin keluar?",
            confirmButtonText = "Keluar",
            dismissButtonText = "Batal",
            openDialog = openDialog
        ) { onClick("LOGOUT") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(brush = Brush.horizontalGradient(colors = gradientColors))
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(65.dp))
            // Profile Picture
            ElevatedCard(
                modifier = modifierElevatedCard,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .size(175.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape),
                        imageVector = ImageVector.vectorResource(id = R.drawable.profile_user),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text(text = "Student's name", style = MaterialTheme.typography.titleLarge)
                        Text(text = "NIS", style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
            Spacer(modifier = modifierSpacer)

            // Student Info
            ElevatedCard(
                modifier = modifierElevatedCard,
                shape = MaterialTheme.shapes.large
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = "STUDENT INFO",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(
                        modifier = Modifier
                            .height(40.dp)
                            .width(2.dp)
                            .background(MaterialTheme.colorScheme.outline)
                    )
                    TextButton(onClick = { onClick(Routes.UpdatePasswordScreen.route) }) {
                        Text(
                            text = "Change Password",
                            style = MaterialTheme.typography.titleSmall
                        )
                        Icon(
                            modifier = Modifier.padding(start = 4.dp),
                            painter = painterResource(R.drawable.baseline_mode_edit_outline_24),
                            contentDescription = "Change Password"
                        )
                    }
                }
            }
            Spacer(modifier = modifierSpacer)

            // Profile
            ElevatedCard(
                modifier = modifierElevatedCard,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp)
                        .padding(bottom = 10.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "PROFILE",
                            style = MaterialTheme.typography.titleMedium
                        )
                        TextButton(onClick = { onClick(Routes.UpdateProfileScreen.route) }) {
                            Text(text = "Edit", style = MaterialTheme.typography.titleMedium)
                            Icon(
                                modifier = Modifier.padding(start = 4.dp),
                                painter = painterResource(R.drawable.baseline_mode_edit_outline_24),
                                contentDescription = "Edit Profile"
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_alternate_email_30),
                            contentDescription = "Student Email"
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Student Email")
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_call_30),
                            contentDescription = "Student Cell Phone"
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Student Cell Phone")
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_class_30),
                            contentDescription = "Student Class"
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Student Class")
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_menu_book_30),
                            contentDescription = "Student Major"
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Student Major")
                    }
                }
            }
            Spacer(modifier = modifierSpacer)

            // Address
            ElevatedCard(
                modifier = modifierElevatedCard,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp, vertical = 10.dp),
                ) {
                    Text(
                        text = "ADDRESS",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "address")
                }
            }
            Spacer(modifier = Modifier.height(25.dp))

            GradientButtonComponent(
                modifier = modifierElevatedCard,
                nameButton = "Logout"
            ) { openDialog.value = true }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}
