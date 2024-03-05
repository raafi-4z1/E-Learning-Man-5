package com.example.e_learningman5.core.features.navigation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.e_learningman5.core.features.navigation.components.Utils.BottomItem
import com.example.e_learningman5.core.features.navigation.components.Utils.myListScreen
import com.example.e_learningman5.core.features.navigation.route.Routes

@Composable
fun BottomNavBarComponent(
    screens: List<BottomItem> = myListScreen(),
    navController: NavHostController,
    onEvent: (String) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val destination = backStackEntry?.destination?.route.toString()

        if (destination != Routes.DetailScreen.route) {
            onEvent(destination)
        }

        Row {
            screens.forEach { bottomItem ->
                val isSelectedItem = destination == bottomItem.title
                NavigationBarItem(
                    selected = isSelectedItem,
                    onClick = {
                        navController.navigate(bottomItem.title) {
                            if (destination == Routes.DetailScreen.route)
                                navController.popBackStack()
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    label = {
                        Text(
                            text = bottomItem.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = if (isSelectedItem) {
                                bottomItem.selectedIcon
                            } else bottomItem.unselectedIcon,
                            contentDescription = bottomItem.title
                        )
                    }
                )
            }
        }
    }
}