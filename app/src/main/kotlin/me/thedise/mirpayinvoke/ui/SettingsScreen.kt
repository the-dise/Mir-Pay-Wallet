package me.thedise.mirpayinvoke.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card
import me.thedise.mirpayinvoke.ui.widgets.cardChip
import me.thedise.mirpayinvoke.ui.widgets.timerChip

@Composable
fun SettingsScreen(
    timerTicks: Int, card: Card, onChangeTimer: (Int) -> Unit, onChangeCard: (Card) -> Unit
) {
    Scaffold(vignette = {
        Vignette(vignettePosition = VignettePosition.TopAndBottom)
    }) {
        ScalingLazyColumn {
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
        }
    }
}
