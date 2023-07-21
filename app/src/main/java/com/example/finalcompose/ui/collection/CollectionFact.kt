package com.example.finalcompose.ui.collection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finalcompose.ui.theme.fauna_outline
import com.example.finalcompose.ui.theme.flora_outline
import com.example.finalcompose.R

@Composable
fun CollectionFact(modifier: Modifier, type: String, funFact: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        var backgroundColor: Color? = null
        var outlineColor: Color? = null
        var titleColor: Color? = null
        var textColor: Color? = null

        if (type == "fauna") {
            backgroundColor = MaterialTheme.colorScheme.tertiaryContainer
            outlineColor = fauna_outline
            titleColor = MaterialTheme.colorScheme.tertiary
            textColor = MaterialTheme.colorScheme.onTertiaryContainer
        } else {
            backgroundColor = MaterialTheme.colorScheme.secondaryContainer
            outlineColor = flora_outline
            titleColor = MaterialTheme.colorScheme.primary
            textColor = MaterialTheme.colorScheme.onSecondaryContainer
        }
        Row(
            modifier = Modifier.fillMaxHeight()
        ) {
            BubbleChat(
                modifier = Modifier.weight(1f).align(Alignment.Top),
                titleColor = titleColor,
                textColor = textColor,
                backgroundColor = backgroundColor,
                funFact = funFact
            )
            Spacer(modifier = Modifier.width(16.dp))
            FlorPhoto(modifier = Modifier.align(Alignment.Bottom), backgroundColor = backgroundColor, outlineColor = outlineColor)
        }
    }
}

@Composable
fun FlorPhoto(modifier: Modifier, backgroundColor: Color, outlineColor: Color) {
    val outlineSize = 4.dp
    val imageSize = 100.dp
    val imageResId = R.drawable.flor_hi

    Box(
        modifier = modifier
            .size(imageSize)
            .clip(CircleShape)
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .border(
                width = outlineSize,
                color = outlineColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(92.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun BubbleChat(
    modifier: Modifier,
    titleColor: Color,
    textColor: Color,
    backgroundColor: Color,
    funFact: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                text = "Did you know?",
                textAlign = TextAlign.Center,
                color = titleColor,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 8.dp),
                text = funFact,
                textAlign = TextAlign.Center,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
