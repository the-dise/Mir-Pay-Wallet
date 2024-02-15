package me.thedise.mirpayinvoke.ui.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import androidx.wear.compose.material.ToggleChipDefaults
import me.thedise.mirpayinvoke.R

fun ScalingLazyListScope.hapticChip(
) = item {
    var checked by remember { mutableStateOf(true) }

    ToggleChip(
        label = {
            Text("Haptic feedback", overflow = TextOverflow.Ellipsis)
        },
        checked = checked,

        colors = ToggleChipDefaults.toggleChipColors(
            uncheckedToggleControlColor = ToggleChipDefaults.SwitchUncheckedIconColor
        ),
        toggleControl = {
            Switch(
                checked = checked,
                enabled = true,
            )
        },
        onCheckedChange = { checked = it },
        appIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_vibration_24),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .wrapContentSize(align = Alignment.Center)
            )
        },
        enabled = true,
    )
}