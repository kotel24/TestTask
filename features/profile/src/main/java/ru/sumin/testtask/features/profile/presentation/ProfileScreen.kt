package ru.sumin.testtask.features.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.sumin.testtask.core.ui.theme.AppBlack

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(AppBlack),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Экран Аккаунта")
    }
}