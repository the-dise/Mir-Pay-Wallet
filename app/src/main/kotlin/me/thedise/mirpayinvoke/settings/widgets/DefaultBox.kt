package me.thedise.mirpayinvoke.settings.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultBox(
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    val shape = RoundedCornerShape(50.dp)

    Box(
        modifier = Modifier
            .clip(shape)
            .fillMaxWidth()
            .background(
                color = Color(0xFF303133),
                shape = shape
            )
            .clickable { onClick() }
            .padding(8.dp) // Add padding for better visual appearance
    ) {
        content()
    }
}
