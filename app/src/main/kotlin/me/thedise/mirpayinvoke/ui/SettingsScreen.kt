package me.thedise.mirpayinvoke.ui

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.ExperimentalWearFoundationApi
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyListAnchorType
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.rememberActiveFocusRequester
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import kotlinx.coroutines.launch
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card
import me.thedise.mirpayinvoke.main.MainActivity
import me.thedise.mirpayinvoke.ui.widgets.cardChip
import me.thedise.mirpayinvoke.ui.widgets.timerChip

@OptIn(ExperimentalWearFoundationApi::class)
@Composable
fun SettingsScreen(
    timerTicks: Int,
    card: Card,
    onChangeTimer: (Int) -> Unit,
    onChangeCard: (Card) -> Unit
) {
    val listState = rememberScalingLazyListState()

    val context = LocalContext.current
    val intent = Intent(context, MainActivity::class.java)


    Scaffold(
        modifier = Modifier.background(Color.Black),
        positionIndicator = {
            PositionIndicator(scalingLazyListState = listState)
        }
    ) {
        val focusRequester = rememberActiveFocusRequester()
        val coroutineScope = rememberCoroutineScope()

        ScalingLazyColumn(
            modifier = Modifier
                .onRotaryScrollEvent {
                    coroutineScope.launch {
                        listState.scrollBy(it.verticalScrollPixels)

                        listState.animateScrollBy(0f)
                    }
                    true
                }
                .focusRequester(focusRequester)
                .focusable(),
            state = listState,

            autoCentering = AutoCenteringParams(itemIndex = 0, itemOffset = 80),
            anchorType = ScalingLazyListAnchorType.ItemStart,
            userScrollEnabled = true
        ) {
            item {
                Text(
                    stringResource(R.string.settings_title),
                    Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 0.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.title3,
                )
            }

            timerChip(
                currentTicks = timerTicks,
                onChangeTimer = onChangeTimer,
            )

            cardChip(
                currentCard = card,
                onChangeCard = onChangeCard
            )

            item {
                Button(onClick = { context.startActivity(intent) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launch_24),
                        contentDescription = null
                    )
                }
            }
        }

    }
}

@Preview(device = "id:wearos_small_round")
@Composable
fun SettingsScreenPreview(modifier: Modifier = Modifier) {
    SettingsScreen(timerTicks = 15, card = Card.PSB, onChangeTimer = {}, onChangeCard = {})
}
