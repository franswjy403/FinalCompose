package com.example.finalcompose.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalcompose.ui.theme.FinalComposeTheme

private val AppBarHeight = 64.dp
private val AppNavHeight = 70.dp
private val AppBarMargin = 16.dp

@Composable
fun ProfileContent() {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(10) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = AppBarMargin,
                )
                .padding(top = AppBarHeight, bottom = AppNavHeight)
                .verticalScroll(state)
        ) {
            ProfileBanner()
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProfileContentPreview() {
    FinalComposeTheme {
        ProfileContent()
    }
}