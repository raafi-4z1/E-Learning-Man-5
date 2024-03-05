package com.example.e_learningman5.core.feature.navigation.route

sealed class Routes(val route: String) {
    data object SplashScreen : Routes("Splash")
    data object LoginScreen : Routes("Login")

    data object HomeScreen : Routes("Home")
    data object DetailScreen : Routes("Detail")
    data object UploadAssignmentsScreen : Routes("UploadAssignments")
    data object RoomChatScreen : Routes("RoomChat")

    data object ProfileScreen : Routes("Profile")
    data object UpdateProfileScreen : Routes("UpdateProfile")
    data object UpdatePasswordScreen : Routes("UpdatePassword")
}