package com.example.finalcompose.ui.collection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val AppBarHeight = 56.dp
private val BottomBarHeight = 72.dp

@Composable
fun CollectionContent(modifier: Modifier, navigateToDetail: (String, String) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = AppBarHeight, bottom = BottomBarHeight)
    ) {
        ContentPager(modifier = modifier, navigateToDetail)
    }
}