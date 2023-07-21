package com.example.finalcompose.ui.collection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalcompose.data.CollectionRepository

@Composable
fun CollectionList(modifier: Modifier, type: String, navigateToDetail: (String, String) -> Unit, collectionRepo: CollectionRepository) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val collections = collectionRepo.getAllCollection(type)
        items(collections) { collection ->
            CollectionItem(
                modifier = modifier, collection = collection,
                navigateToDetail = navigateToDetail
            )
        }
    }
}

