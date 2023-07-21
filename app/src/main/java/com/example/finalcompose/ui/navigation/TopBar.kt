package com.example.finalcompose.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color

private val topBarTitle = mapOf(
    "collection" to "Collection",
    "profile" to "Profile",
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController, modifier: Modifier){
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val title = topBarTitle[currentRoute]

    TopAppBar(
        title = { Text(
            text = title ?: "Collection",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        ) },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Help, contentDescription = "Help")
            }
        },
        modifier = modifier.fillMaxWidth().background(color = Color.White)
    )
}