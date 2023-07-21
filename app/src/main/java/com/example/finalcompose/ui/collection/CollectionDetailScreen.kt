package com.example.finalcompose.ui.collection

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.finalcompose.data.CollectionRepository


@Composable
fun CollectionDetailScreen(type: String, collectionId: String) {
    CollectionDetailContent(
        modifier = Modifier,
        type = type,
        collectionId = collectionId,
        collectionRepo = CollectionRepository()
    )
}