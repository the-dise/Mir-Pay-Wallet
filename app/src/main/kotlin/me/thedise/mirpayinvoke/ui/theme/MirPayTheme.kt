package me.thedise.mirpayinvoke.ui.theme

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.wear.compose.material.Colors
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Typography
import me.thedise.mirpayinvoke.R

val MirPayColors = Colors(

    /* Stock Colors *//* For the future when they will add an open API of dynamic colors for Wear OS */
    primary = Color(0xFFAECBFA),
    primaryVariant = Color(0xFF8AB4F8),
    secondary = Color(0xFFFDE293),
    secondaryVariant = Color(0xFF594F33),
    background = Color.Black,
    surface = Color(0xFF303133),
    error = Color(0xFFEE675C),
    onPrimary = Color(0xFF303133),
    onSecondary = Color(0xFF303133),
    onBackground = Color.White,
    onSurface = Color.White,
    onSurfaceVariant = Color(0xFFDADCE0),
    onError = Color(0xFF000000)
)

val MirPayFonts = Typography(
    defaultFontFamily = if (Build.MANUFACTURER.equals("Google", ignoreCase = true)) {
        FontFamily(Font(R.font.google_sans, FontWeight.Normal))
    } else {
        FontFamily.Default
    }
)

@Composable
fun MirPayTheme(block: @Composable () -> Unit) {
    MaterialTheme(
        colors = MirPayColors,
        typography = MirPayFonts
    ) {
        block()
    }
}