package me.thedise.mirpayinvoke.settings.widgets

import android.app.RemoteInput
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.CardDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import androidx.wear.input.RemoteInputIntentHelper
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.DEFAULT_TIMER

private const val TIMER_KEY = "timer"
private val DEFAULT_VALUES = arrayOf(
    "5", "10", "15", "20", "25", "30", "35", "40", "45", "50",
    "55", "60"
)

fun ScalingLazyListScope.timerBlock(
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

    TitleCard(
        onClick = { launcher.launch(createIntent(label)) },
        title = { Text(stringResource(R.string.settings_timer_title)) },
        backgroundPainter = CardDefaults.cardBackgroundPainter(),
        contentColor = MaterialTheme.colors.onSurfaceVariant,
        titleColor = MaterialTheme.colors.onSurface,
    ) {
        Text(newTimer.toString())
    }
}

private fun createIntent(label: String) = RemoteInputIntentHelper.putRemoteInputsExtra(
    intent = RemoteInputIntentHelper.createActionRemoteInputIntent(), remoteInputs = listOf(
        RemoteInput.Builder(TIMER_KEY).setLabel(label).setAllowFreeFormInput(false)
            .setChoices(DEFAULT_VALUES).build()
    )
)
