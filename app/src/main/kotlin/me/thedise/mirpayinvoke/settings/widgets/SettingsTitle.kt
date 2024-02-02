package me.thedise.mirpayinvoke.settings.widgets

import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material.ScalingLazyListScope
import androidx.wear.compose.material.Text
import me.thedise.mirpayinvoke.R

fun ScalingLazyListScope.settingsTitle() = item {
    Text(text = stringResource(R.string.settings_title))
}
