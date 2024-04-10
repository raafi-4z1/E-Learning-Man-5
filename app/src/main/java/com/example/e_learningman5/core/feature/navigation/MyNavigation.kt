package com.example.e_learningman5.core.feature.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.e_learningman5.core.feature.navigation.components.BottomNavBarComponent
import com.example.e_learningman5.core.feature.navigation.components.TopAppBarComponent
import com.example.e_learningman5.core.feature.navigation.graph.Graph
import com.example.e_learningman5.core.feature.navigation.route.Routes
import com.example.e_learningman5.core.feature.splash.SplashScreenCompose
import com.example.e_learningman5.main.feature.home.screen.detail.DetailScreen
import com.example.e_learningman5.main.feature.home.screen.home.HomeScreen
import com.example.e_learningman5.login.feature.LoginScreen
import com.example.e_learningman5.login.feature.LoginViewModel
import com.example.e_learningman5.main.feature.profile.screen.profile.ProfileScreen
import com.example.e_learningman5.main.feature.profile.screen.update.UpdatePasswordScreen
import com.example.e_learningman5.main.feature.profile.screen.update.UpdateProfileScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun MyNavigation(navController: NavHostController = rememberNavController()) {
    var destinationRoute by remember { mutableStateOf(Routes.SplashScreen.route) }
    var isEnableBottomBar by remember { mutableStateOf(false) }
    var isEnableBackNavIcon by remember { mutableStateOf(false) }
    var appScopeAuth: Scope

    Scaffold(
        bottomBar = {
            if (isEnableBottomBar)
                BottomNavBarComponent(
                    navController = navController,
                    onEvent = { destinationRoute = it }
                )
        },
        topBar = {
            if (destinationRoute != Routes.SplashScreen.route)
                TopAppBarComponent(
                    titleTopAppBar = destinationRoute,
                    isEnableNavIcon = isEnableBackNavIcon,
                    onClick = { navController.popBackStack() }
                )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            NavHost(
                navController = navController,
                route = Graph.ROOT,
                startDestination = Graph.AUTHENTICATION
            ) {
                navigation(
                    route = Graph.AUTHENTICATION,
                    startDestination = Routes.SplashScreen.route
                ) {
                    composable(route = Routes.SplashScreen.route) {
                        val viewModelStoreOwner = remember(this) {
                            navController.getBackStackEntry(Graph.AUTHENTICATION)
                        }
                        appScopeAuth = getKoin().getOrCreateScope(
                            "app_scope_auth",
                            named(Graph.AUTHENTICATION)
                        )
                        isEnableBottomBar = false
                        destinationRoute = Routes.SplashScreen.route
                        SplashScreenCompose(
                            koinViewModel<LoginViewModel>(
                                viewModelStoreOwner = viewModelStoreOwner,
                                scope = appScopeAuth
                            ),
                            onSession = {
                                navController.navigate(Graph.HOME) {
                                    popUpTo(Graph.AUTHENTICATION) {
                                        inclusive = true
                                    }
                                    appScopeAuth.close()
                                }
                            }
                        ) { paramSession ->
                            navController.navigate(Routes.LoginScreen.route + "?param=$paramSession") {
                                popUpTo(Routes.SplashScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                    composable(
                        route = Routes.LoginScreen.route + "?param={param}",
                        arguments = listOf(
                            navArgument("param") { type = NavType.StringType }
                        )
                    ) { navBackStackEntry ->
                        val viewModelStoreOwner = remember(this) {
                            navController.getBackStackEntry(Graph.AUTHENTICATION)
                        }
                        appScopeAuth = getKoin().getOrCreateScope(
                            "app_scope_auth",
                            named(Graph.AUTHENTICATION)
                        )
                        isEnableBottomBar = false
                        isEnableBackNavIcon = false
                        destinationRoute = Routes.LoginScreen.route
                        LoginScreen(
                            koinViewModel<LoginViewModel>(
                                viewModelStoreOwner = viewModelStoreOwner,
                                scope = appScopeAuth
                            ),
                            navBackStackEntry.arguments?.getString("param") ?: "0"
                        ) {
                            navController.navigate(Graph.HOME) {
                                popUpTo(Graph.AUTHENTICATION) {
                                    inclusive = true
                                }
                                appScopeAuth.close()
                            }
                        }
                    }
                }

                navigation(
                    route = Graph.HOME,
                    startDestination = Routes.HomeScreen.route
                ) {
                    composable(route = Routes.HomeScreen.route) {
                        isEnableBottomBar = true
                        isEnableBackNavIcon = false
                        HomeScreen { itemImageCard ->
                            destinationRoute = itemImageCard
                            navController.navigate(Routes.DetailScreen.route) {
                                launchSingleTop = true
                            }
                        }
                    }
                    composable(route = Routes.ProfileScreen.route) {
                        isEnableBottomBar = true
                        isEnableBackNavIcon = false
                        ProfileScreen { onClick ->
                            when (onClick) {
                                Routes.UpdateProfileScreen.route ->
                                    navController.navigate(Routes.UpdateProfileScreen.route)

                                Routes.UpdatePasswordScreen.route ->
                                    navController.navigate(Routes.UpdatePasswordScreen.route)

                                "LOGOUT" -> {
                                    navController.navigate(Graph.ROOT) {
                                        popUpTo(Graph.HOME) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                navigation(
                    route = Graph.DETAILS,
                    startDestination = Routes.DetailScreen.route
                ) {
                    composable(route = Routes.DetailScreen.route) {
                        isEnableBottomBar = true
                        isEnableBackNavIcon = true
                        DetailScreen()
                    }
                    composable(route = Routes.UploadAssignmentsScreen.route) {
                        isEnableBottomBar = false
                        isEnableBackNavIcon = true
                    }
                    composable(route = Routes.RoomChatScreen.route) {
                        isEnableBottomBar = false
                        isEnableBackNavIcon = true
                        destinationRoute = Routes.RoomChatScreen.route
                    }
                }

                composable(route = Routes.UpdateProfileScreen.route) {
                    isEnableBottomBar = false
                    isEnableBackNavIcon = true
                    destinationRoute = "Update Profile"
                    UpdateProfileScreen {
                        // Update Profile
                        Log.d("Update Profile", "click")
                        navController.popBackStack()
                    }
                }

                composable(route = Routes.UpdatePasswordScreen.route) {
                    isEnableBottomBar = false
                    isEnableBackNavIcon = true
                    destinationRoute = "Update Password"
                    UpdatePasswordScreen {
                        // Update Password
                        Log.d("Update Password", "click")
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}
