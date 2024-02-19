package me.thedise.mirpayinvoke.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun SettingsScreen(
    timerTicks: Int,
    card: Card,
    onChangeTimer: (Int) -> Unit,
    onChangeCard: (Card) -> Unit,
    onToggleHaptic: Boolean,
    onToggleHapticAction: (Boolean) -> Unit
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

                hapticChip(
                    onToggleHaptic = onToggleHaptic,
                    onToggleHapticAction = onToggleHapticAction,
                )

                timerChip(
                    currentTicks = timerTicks,
                    onChangeTimer = onChangeTimer,
                )

                cardChip(
                    currentCard = card, onChangeCard = onChangeCard
                )
            }
        }
    }
}
