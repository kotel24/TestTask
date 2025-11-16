package ru.sumin.testtask.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = AppGreen,
    background = AppBlack,
    surface = AppBlack,
    onPrimary = AppWhite,
    onBackground = AppWhite,
    onSurface = AppWhite,
    surfaceVariant = AppDarkGray,
    onSurfaceVariant = AppLightGray
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = AppTypography,
        content = content
    )
}