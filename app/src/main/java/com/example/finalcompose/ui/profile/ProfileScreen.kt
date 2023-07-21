package com.example.finalcompose.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalcompose.ui.theme.FinalComposeTheme

@Composable
fun ProfileScreen() {
    ProfileContent()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun ProfileScreenPreview() {
    FinalComposeTheme() {
        ProfileScreen()
    }
}