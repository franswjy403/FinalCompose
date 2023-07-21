package com.example.finalcompose.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalcompose.model.UserProfile
import com.example.finalcompose.ui.theme.*
import com.example.finalcompose.data.userProfile

@Composable
fun ProfileBanner() {
    val center = Offset(530f, 0f)
    val brush = Brush.radialGradient(
        colors = listOf(
            center_radial_gradient,
            center_radial_gradient,
            middle_radial_gradient,
            outer_radial_gradient,
            outer_radial_gradient
        ),
        center = center,
        radius = 600f
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = brush,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfilePicture(user = userProfile)
            UserInformation(user = userProfile)
        }
    }
}

@Composable
fun UserInformation(user: UserProfile) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = user.name,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = user.email,
            color = user_information,
            style = MaterialTheme.typography.bodyMedium
        )
        Row {
            Icon(Icons.Outlined.LocationOn, "location", tint = user_information)
            Text(
                modifier= Modifier.padding(horizontal = 4.dp),
                text = user.location,
                color = user_information,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}

@Composable
fun ProfilePicture(user: UserProfile) {
    val imageSize = 120.dp
    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(user.profileResId),
                contentDescription = null,
                modifier = Modifier.size(imageSize),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProfileBannerReview() {
    FinalComposeTheme {
        ProfileBanner()
    }
}