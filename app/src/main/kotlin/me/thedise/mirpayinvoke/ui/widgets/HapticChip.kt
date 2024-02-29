package me.thedise.mirpayinvoke.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import me.thedise.mirpayinvoke.R

fun ScalingLazyListScope.hapticChip(
    onToggleHaptic: Boolean, onToggleHapticAction: (Boolean) -> Unit

) = item {
    var checked by remember { mutableStateOf(onToggleHaptic) }

    ToggleChip(
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                stringResource(id = R.string.settings_haptic_feedback_label),
                overflow = TextOverflow.Ellipsis
            )
        },
        secondaryLabel = {
            Text(
                text = stringResource(R.string.settings_haptic_feedback_secondary), maxLines = 1
            )
        },
        checked = checked,
        toggleControl = {
            Switch(
                checked = checked
            )
        },
        onCheckedChange = { newChecked ->
            checked = newChecked
            onToggleHapticAction(newChecked)
        },
        appIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_vibration_24),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .wrapContentSize(align = Alignment.Center),
                tint = MaterialTheme.colors.primary
            )
        },
        enabled = true,
    )
}