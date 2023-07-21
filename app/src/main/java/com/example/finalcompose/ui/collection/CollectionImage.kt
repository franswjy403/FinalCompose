package com.example.finalcompose.ui.collection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.finalcompose.ui.theme.fauna_outline
import com.example.finalcompose.ui.theme.flora_outline

@Composable
fun CollectionImage(modifier: Modifier, type: String, photoUrl: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(172.dp)
    ) {
        ImageBox(modifier = modifier, type = type, photoUrl = photoUrl)
        TypeLabel(modifier = modifier.align(Alignment.BottomStart), type = type)
    }
}

@Composable
fun ImageBox(modifier: Modifier, type: String, photoUrl: String) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        val backgroundColor: Color = if (type == "fauna") fauna_outline else flora_outline

        Box(
            modifier = modifier
                .fillMaxWidth(0.99f)
                .height(164.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .align(Alignment.BottomCenter)
        ) {

        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(168.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = Color.Blue,
                    shape = RoundedCornerShape(16.dp)
                )
                .align(Alignment.TopCenter)
        ) {

            Image(
                painter = rememberImagePainter(data = photoUrl),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun TypeLabel(modifier: Modifier, type: String) {
    var labelBackgroundColor: Color? = null
    var labelContentColor: Color? = null

    if (type == "fauna") {
        labelBackgroundColor = MaterialTheme.colorScheme.tertiaryContainer
        labelContentColor = MaterialTheme.colorScheme.tertiary
    } else {
        labelBackgroundColor = MaterialTheme.colorScheme.secondaryContainer
        labelContentColor = MaterialTheme.colorScheme.primary
    }

    Box(
        modifier = modifier
            .padding(16.dp)
            .width(85.dp)
            .height(28.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = labelBackgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (type == "fauna") {
                Icon(
                    imageVector = Icons.Filled.Pets,
                    contentDescription = "Fauna",
                    modifier = Modifier.size(18.dp),
                    tint = labelContentColor,
                )

            } else {
                Icon(
                    imageVector = Icons.Filled.Eco,
                    contentDescription = "Flora",
                    modifier = Modifier.size(18.dp),
                    tint = labelContentColor,
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(
                text = "Fauna",
                color = labelContentColor,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}