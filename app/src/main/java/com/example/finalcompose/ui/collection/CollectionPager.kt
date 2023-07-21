package com.example.finalcompose.ui.collection

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.finalcompose.data.CollectionRepository

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentPager(modifier: Modifier, navigateToDetail: (String, String) -> Unit) {
    val items = listOf("Fauna", "Flora")
    val pagerState = rememberPagerState()

    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val indicatorSpacing = 8.dp

                repeat(items.size) { index ->
                    val color = if (index == pagerState.currentPage) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Transparent
                    }
                    val indicatorTitle = if (index == 0) "Fauna" else "Flora"

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (index == 0) {
                                Icon(
                                    imageVector = Icons.Filled.Pets,
                                    contentDescription = "Fauna",
                                    modifier = modifier.size(18.dp)
                                )

                            } else {
                                Icon(
                                    imageVector = Icons.Filled.Eco,
                                    contentDescription = "Flora",
                                    modifier = modifier.size(18.dp)
                                )
                            }
                            Text(
                                modifier = modifier
                                    .padding(top = 4.dp)
                                    .padding(horizontal = 4.dp),
                                text = indicatorTitle
                            )
                        }
                        Box(
                            modifier = Modifier
                                .height(2.dp)
                                .width(180.dp)
                                .background(color = color)
                        )
                    }


                    if (index != items.size - 1) {
                        Spacer(modifier = Modifier.width(indicatorSpacing))
                    }
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                pageCount = items.size
            ) { page ->
                if (page == 0)
                    CollectionList(modifier = modifier, type = "fauna", navigateToDetail, collectionRepo = CollectionRepository())
                else
                    CollectionList(modifier = modifier, type = "flora", navigateToDetail, collectionRepo = CollectionRepository())
            }
        }

    }
}
