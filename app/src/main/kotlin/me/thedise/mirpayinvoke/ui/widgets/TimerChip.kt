package me.thedise.mirpayinvoke.ui.widgets

import android.app.RemoteInput
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.DEFAULT_TIMER

private const val TIMER_KEY = "timer"
private val DEFAULT_VALUES = arrayOf(
    "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60"
)

fun ScalingLazyListScope.timerChip(
    currentTicks: Int,
    onChangeTimer: (Int) -> Unit,
) = item {
    var newTimer by remember { mutableIntStateOf(currentTicks) }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.let { data ->
                val results = RemoteInput.getResultsFromIntent(data)
                newTimer = (results.getString(TIMER_KEY) ?: DEFAULT_TIMER.toString()).toInt()
                onChangeTimer(newTimer)
            }
        }

    val label = stringResource(R.string.settings_enter_ms)

    Chip(modifier = Modifier.fillMaxWidth(),
        onClick = { launcher.launch(createIntent(label)) },
        label = {
            Text(
                text = stringResource(id = R.string.settings_timer_title), maxLines = 1
            )
        },

        secondaryLabel = {
            Text(text = newTimer.toString())
        },
        colors = ChipDefaults.secondaryChipColors(),
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_timer_24),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .wrapContentSize(align = Alignment.Center)
            )
        })
}

private fun createIntent(label: String) = RemoteInputIntentHelper.putRemoteInputsExtra(
    intent = RemoteInputIntentHelper.createActionRemoteInputIntent(), remoteInputs = listOf(
        RemoteInput.Builder(TIMER_KEY).setLabel(label).setAllowFreeFormInput(false)
            .setChoices(DEFAULT_VALUES).build()
    )
)
