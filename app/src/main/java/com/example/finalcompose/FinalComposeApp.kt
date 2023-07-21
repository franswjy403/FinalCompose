package com.example.finalcompose

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalcompose.ui.collection.CollectionDetailScreen
import com.example.finalcompose.ui.collection.CollectionScreen
import com.example.finalcompose.ui.navigation.BottomNavigation
import com.example.finalcompose.ui.navigation.Screen
import com.example.finalcompose.ui.navigation.TopBackNavigation
import com.example.finalcompose.ui.navigation.TopBar
import com.example.finalcompose.ui.profile.ProfileScreen
import com.example.finalcompose.ui.theme.FinalComposeTheme

@Composable
fun FinalComposeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.CollectionDetail.route)
                TopBackNavigation(navController = navController, title = "Details")
            else {
                TopBar(
                    navController = navController,
                    modifier = Modifier
                )
            }
        },
        bottomBar = {
            if (currentRoute != Screen.CollectionDetail.route) BottomNavigation(
                navController,
                modifier = Modifier
            )
        },
        modifier = modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Collection.route,
        ) {
            composable(Screen.Collection.route) {
                CollectionScreen(
                    navigateToDetail = { collectionId, type ->
                        navController.navigate(
                            Screen.CollectionDetail.createRoute(
                                collectionId,
                                type
                            )
                        )
                    }
                )
            }

            composable(
                route = Screen.CollectionDetail.route,
                arguments = listOf(navArgument("collectionId") { type = NavType.StringType }, navArgument("type") {type = NavType.StringType}),
            ) {
                val collectionId = it.arguments?.getString("collectionId") ?: ""
                val type = it.arguments?.getString("type") ?: "fauna"
                CollectionDetailScreen(collectionId = collectionId, type = type)
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_3A,
    showSystemUi = true
)
@Composable
fun FinalComposeAppPreview() {
    FinalComposeTheme {
        FinalComposeApp()
    }
}