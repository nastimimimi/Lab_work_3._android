package com.example.votingapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF5B5FEF),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE8E9FF),
    onPrimaryContainer = Color(0xFF1A1C6B),
    secondary = Color(0xFF5E5E7A),
    background = Color(0xFFF5F5FA),
    surface = Color.White,
    surfaceVariant = Color(0xFFF0F0F8),
    onSurface = Color(0xFF1C1B1F),
    onSurfaceVariant = Color(0xFF77767F),
    outline = Color(0xFFCAC4D0),
    outlineVariant = Color(0xFFE6E1E5),
    error = Color(0xFFB3261E)
)

@Composable
fun VotingAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
