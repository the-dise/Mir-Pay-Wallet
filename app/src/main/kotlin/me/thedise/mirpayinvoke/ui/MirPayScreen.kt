package me.thedise.mirpayinvoke.ui

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.thedise.mirpayinvoke.common.Card
import me.thedise.mirpayinvoke.ui.widgets.AnimatedCounter
import me.thedise.mirpayinvoke.ui.widgets.LogoBlock

@Suppress("DEPRECATION")
@Composable
fun MirPayScreen(
    context: Context, maxTicks: Int, card: Card, onTimerEnd: () -> Unit, onToggleHaptic: Boolean
) {
    var currentTicks by remember { mutableIntStateOf(0) }
    var timerJob by remember { mutableStateOf<Job?>(null) }
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp, vertical = 16.dp
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(card.colorId.toInt()).copy(alpha = 1f), Color.Black
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier.align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoBlock()
        }

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp)
                .shadow(
                    elevation = 16.dp,
                    clip = true,
                    shape = RoundedCornerShape(8.dp),
                    spotColor = Color.Black
                ), painter = painterResource(card.imageId), contentDescription = null
        )

        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            AnimatedCounter(
                count = (maxTicks - currentTicks),
            )
        }
    }

    LaunchedEffect(Unit) {
        Log.d("MirPayWear", "Haptic feedback is $onToggleHaptic")

        if (onToggleHaptic) { // Check if haptic feedback is enabled
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    300, VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        }

        timerJob = launch {
            repeat(maxTicks) {
                delay(1000)
                currentTicks++

                if (currentTicks == maxTicks) {
                    vibrator.vibrate(
                        VibrationEffect.createOneShot(
                            400, VibrationEffect
                                .DEFAULT_AMPLITUDE
                        )
                    )
                    onTimerEnd()
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            timerJob?.cancel()
        }
    }
}

@Preview(
    device = "id:wearos_small_round",
    showSystemUi = true,
    backgroundColor = 0xFF000000,
    showBackground = true
)
@Composable
fun MirPayScreenPreview() {
    MirPayScreen(maxTicks = 15, card = Card.DEFAULT) {

    }
}

