package com.example.finalcompose.ui.collection

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CollectionScreen(
    navigateToDetail: (String, String) -> Unit,
) {
    CollectionContent(modifier = Modifier, navigateToDetail)
}
