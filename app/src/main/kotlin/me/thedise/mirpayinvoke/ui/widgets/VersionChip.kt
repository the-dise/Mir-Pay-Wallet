package me.thedise.mirpayinvoke.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import me.thedise.mirpayinvoke.BuildConfig
import me.thedise.mirpayinvoke.R

fun ScalingLazyListScope.versionChip() = item {

    Chip(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /* no-op */ },
        colors = ChipDefaults.secondaryChipColors(),
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_info_24),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .wrapContentSize(align = Alignment.Center),
                tint = MaterialTheme.colors.primary
            )
        },
        label = {
            Text(text = stringResource(R.string.settings_app_version))
        },
        secondaryLabel = {
            Text(text = BuildConfig.VERSION_NAME)
        },
    )
}
