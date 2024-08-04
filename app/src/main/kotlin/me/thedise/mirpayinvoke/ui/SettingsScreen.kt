package me.thedise.mirpayinvoke.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.scrollAway
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.rotaryinput.rotaryWithScroll
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card
import me.thedise.mirpayinvoke.ui.theme.MirPayTheme
import me.thedise.mirpayinvoke.ui.widgets.cardChip
import me.thedise.mirpayinvoke.ui.widgets.hapticChip
import me.thedise.mirpayinvoke.ui.widgets.timerChip
import me.thedise.mirpayinvoke.ui.widgets.versionChip
import me.thedise.mirpayinvoke.ui.widgets.vibrateEverySecondChip
import me.thedise.mirpayinvoke.ui.widgets.vibrationIntensityChip

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun SettingsScreen(
    timerTicks: Int,
    card: Card,
    vibrationIntensity: Int,
    onChangeTimer: (Int) -> Unit,
    onChangeCard: (Card) -> Unit,
    onChangeVibrationIntensity: (Int) -> Unit,
    onToggleHaptic: Boolean,
    onToggleHapticAction: (Boolean) -> Unit,
    onToggleVibrateEverySecond: Boolean,
    onToggleVibrateEverySecondAction: (Boolean) -> Unit
) {
    MirPayTheme {
        val state = rememberScalingLazyListState()

        Scaffold(positionIndicator = {
            PositionIndicator(state)
        }, vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        }, timeText = {
            TimeText(modifier = Modifier.scrollAway(state))
        }) {
            ScalingLazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .rotaryWithScroll(scrollableState = state),
                state = state,
            ) {
                item {
                    ListHeader {
                        Text(
                            text = stringResource(R.string.settings_title)
                        )
                    }
                }

                timerChip(
                    currentTicks = timerTicks,
                    onChangeTimer = onChangeTimer,
                )

                cardChip(
                    currentCard = card, onChangeCard = onChangeCard
                )

                item {
                    ListHeader {
                        Text(
                            text = stringResource(R.string.settings_haptic_feedback)
                        )
                    }
                }

                hapticChip(
                    onToggleHaptic = onToggleHaptic,
                    onToggleHapticAction = onToggleHapticAction,
                )

                vibrateEverySecondChip(
                    onToggleVibrateEverySecond = onToggleVibrateEverySecond,
                    onToggleVibrateEverySecondAction = onToggleVibrateEverySecondAction,
                )

                vibrationIntensityChip(
                    currentMs = vibrationIntensity,
                    onChangeVibrationIntensity = onChangeVibrationIntensity,
                )

                item {
                    ListHeader {
                        Text(
                            text = stringResource(R.string.settings_about)
                        )
                    }
                }
                
                versionChip()
            }
        }
    }
}

@Preview(
    device = "id:wearos_small_round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFF000000,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_WATCH, locale = "ru"
)
@Composable
fun SettingsScreenPreview() {
    val timerTicks = 10
    val card = Card.DEFAULT
    val vibrationIntensity = 75
    val onChangeTimer: (Int) -> Unit = {}
    val onChangeCard: (Card) -> Unit = {}
    val onChangeVibrationIntensity: (Int) -> Unit = {}
    val onToggleHaptic = false
    val onToggleHapticAction: (Boolean) -> Unit = {}
    val onToggleVibrateEverySecond = false
    val onToggleVibrateEverySecondAction: (Boolean) -> Unit = {}

    SettingsScreen(
        timerTicks = timerTicks,
        card = card,
        vibrationIntensity = vibrationIntensity,
        onChangeTimer = onChangeTimer,
        onChangeCard = onChangeCard,
        onChangeVibrationIntensity = onChangeVibrationIntensity,
        onToggleHaptic = onToggleHaptic,
        onToggleHapticAction = onToggleHapticAction,
        onToggleVibrateEverySecond = onToggleVibrateEverySecond,
        onToggleVibrateEverySecondAction = onToggleVibrateEverySecondAction
    )
}