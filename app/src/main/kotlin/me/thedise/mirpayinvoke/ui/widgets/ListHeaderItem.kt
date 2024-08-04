package me.thedise.mirpayinvoke.ui.widgets

import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.Text

fun ScalingLazyListScope.listHeaderItem(settingsTitle: Int) {
    item {
        ListHeader {
            Text(
                text = stringResource(id = settingsTitle)
            )
        }
    }
}