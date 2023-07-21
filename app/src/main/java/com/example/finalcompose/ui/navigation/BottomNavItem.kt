package com.example.finalcompose.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val iconFocused: ImageVector,
    val iconUnfocused: ImageVector,
    val screen: Screen
)
