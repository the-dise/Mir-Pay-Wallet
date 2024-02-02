package me.thedise.mirpayinvoke.settings.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.wear.compose.material.ScalingLazyListScope

fun ScalingLazyListScope.spacer(height: Dp) = item { Spacer(modifier = Modifier.height(height)) }
