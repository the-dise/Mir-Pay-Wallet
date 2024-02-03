package me.thedise.mirpayinvoke.main.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounter(
    modifier: Modifier = Modifier,
    count: Int,
) {
    AnimatedContent(
        modifier = modifier,
        targetState = count,
        transitionSpec = {
            slideInVertically { it } + fadeIn() with slideOutVertically { -it } + fadeOut()
        }, label = "countdown"
    ) {
        Text(
            text = it.toString(),
            fontSize = 16.sp,
            fontFamily = googleSans,
            softWrap = false
        )
    }
}
