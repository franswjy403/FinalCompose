package com.example.finalcompose.ui.collection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalcompose.data.CollectionRepository

private val AppBarHeight = 80.dp
private val AppBarMargin = 16.dp

@Composable
fun CollectionDetailContent(
    modifier: Modifier,
    type: String,
    collectionId: String,
    collectionRepo: CollectionRepository,
) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(10) }

    val collection = collectionRepo.getOneCollection(type, collectionId)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = AppBarMargin)
            .padding(top = AppBarHeight, bottom = 4.dp)
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CollectionImage(modifier = modifier, type = type, collection!!.photoUrl)
        CollectionDescription(modifier = modifier, name = collection.name, latin = collection.latin, description = collection.description)
        CollectionFact(modifier = Modifier, type = type, funFact = collection.funFact)
    }
}