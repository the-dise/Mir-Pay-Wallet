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
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.DEFAULT_VIBRATION_INTENSITY

private const val VIBRATION_INTENSITY_KEY = "vibration_intensity"
private val DEFAULT_VALUES = arrayOf(
    "10", "25", "50", "75", "100", "125", "150", "175", "200"
)

fun ScalingLazyListScope.vibrationIntensityChip(
    currentMs: Int,
    onChangeVibrationIntensity: (Int) -> Unit,
) = item {
    var newIntensity by remember { mutableIntStateOf(currentMs) }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.let { data ->
                val results = RemoteInput.getResultsFromIntent(data)
                newIntensity = (results.getString(VIBRATION_INTENSITY_KEY) ?: DEFAULT_VIBRATION_INTENSITY.toString()).toInt()
                onChangeVibrationIntensity(newIntensity)
            }
        }

    val label = stringResource(R.string.settings_enter_vibration_intensity)

    Chip(modifier = Modifier.fillMaxWidth(),
        onClick = { launcher.launch(createIntent(label)) },
        label = {
            Text(
                text = stringResource(id = R.string.settings_vibration_intensity_title), maxLines = 1
            )
        },

        secondaryLabel = {
            Text(text = newIntensity.toString())
        },
        colors = ChipDefaults.secondaryChipColors(),
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_vibration_24),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .wrapContentSize(align = Alignment.Center),
                tint = MaterialTheme.colors.primary
            )
        })
}

private fun createIntent(label: String) = RemoteInputIntentHelper.putRemoteInputsExtra(
    intent = RemoteInputIntentHelper.createActionRemoteInputIntent(), remoteInputs = listOf(
        RemoteInput.Builder(VIBRATION_INTENSITY_KEY).setLabel(label).setAllowFreeFormInput(false)
            .setChoices(DEFAULT_VALUES).build()
    )
)
