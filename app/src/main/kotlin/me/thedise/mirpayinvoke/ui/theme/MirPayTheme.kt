package me.thedise.mirpayinvoke.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Colors
import androidx.wear.compose.material.MaterialTheme

val MirPayColors = Colors(
    primary = Color(0xFF008452),
    primaryVariant = Color(0xFF3DA37B),
    secondary = Color(0xFF1F5BD7),
    secondaryVariant = Color(0xFF8FADEB)
)

@Composable
fun MirPayTheme(block: @Composable () -> Unit) {
    MaterialTheme(colors = MirPayColors) {
        block()
    }
}