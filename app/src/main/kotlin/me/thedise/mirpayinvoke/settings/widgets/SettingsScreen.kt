package me.thedise.mirpayinvoke.settings.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ScalingLazyColumn
import me.thedise.mirpayinvoke.common.Card

@Composable
fun SettingsScreen(
    timerTicks: Int,
    card: Card,
    onChangeTimer: (Int) -> Unit,
    onChangeCard: (Card) -> Unit
) {
    ScalingLazyColumn(modifier = Modifier.fillMaxSize()) {
        settingsTitle()

        spacer(8.dp)

        timerBlock(
            currentTicks = timerTicks,
            onChangeTimer = onChangeTimer,
        )

        cardBlock(
            currentCard = card,
            onChangeCard = onChangeCard
        )
    }
}

@Preview(device = "id:wearos_small_round")
@Composable
fun MainActivityScreenPreview() {
    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        settingsTitle()

        spacer(8.dp)

        // Example values for preview
        timerBlock(
            currentTicks = 30,
            onChangeTimer = { /* Handle timer change in preview */ }
        )

        cardBlock(
            currentCard = Card.DEFAULT,
            onChangeCard = { /* Handle card change in preview */ }
        )
    }

}
