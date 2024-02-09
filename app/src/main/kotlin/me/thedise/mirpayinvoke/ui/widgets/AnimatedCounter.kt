package me.thedise.mirpayinvoke.ui.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

@Suppress("NAME_SHADOWING")
@Composable
fun AnimatedCounter(
    count: Int, modifier: Modifier = Modifier, style: TextStyle = MaterialTheme.typography.title3
) {
    var oldCount by remember {
        mutableIntStateOf(count)
    }

    SideEffect {
        oldCount = count
    }
    Row(modifier = modifier) {
        val countString = String.format("%02d", count.coerceIn(0, 99))
        val oldCountString = String.format("%02d", oldCount.coerceIn(0, 99))

        for (i in countString.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]
            val char = if (oldChar == newChar) {
                oldCountString[i]
            } else {
                countString[i]
            }
            AnimatedContent(
                targetState = char, transitionSpec = {
                    (slideInVertically { it } + fadeIn()).togetherWith(slideOutVertically { -it } + fadeOut())
                }, label = "countdown"
            ) { char ->
                Text(
                    text = char.toString(), style = style
                )
            }
        }
    }
}
