package me.thedise.mirpayinvoke.ui

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.wear.compose.foundation.rememberSwipeToDismissBoxState
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import androidx.wear.compose.navigation.rememberSwipeDismissableNavHostState
import me.thedise.mirpayinvoke.common.AppStorage
import me.thedise.mirpayinvoke.common.Nfc

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WearApp(
    appStorage: AppStorage, context: Context, onTimerEnd: () -> Unit, nfc: Nfc?
) {
    val navController = rememberSwipeDismissableNavController()
    val swipeToDismissBoxState = rememberSwipeToDismissBoxState()
    val navHostState =
        rememberSwipeDismissableNavHostState(swipeToDismissBoxState = swipeToDismissBoxState)


    SwipeDismissableNavHost(
        startDestination = "mirPay", navController = navController, state = navHostState
    ) {
        composable(route = "mirPay") {
            val state = rememberPagerState(pageCount = { 2 })
            val shape = if (LocalConfiguration.current.isScreenRound) CircleShape else null
            Box(modifier = Modifier.fillMaxSize()) {
                HorizontalPager(modifier = Modifier.fillMaxSize(), state = state) { page ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                            .run {
                                if (shape != null) {
                                    clip(shape)
                                } else {
                                    this
                                }
                            }, contentAlignment = Alignment.Center
                    ) {
                        when (page) {
                            0 -> MirPayScreen(
                                context = context,
                                nfc = nfc,
                                maxTicks = appStorage.timerTicks,
                                card = appStorage.card,
                                vibrationIntensity = appStorage.vibrationIntensity,
                                onTimerEnd = onTimerEnd,
                                onToggleHaptic = appStorage.haptic, // Pass haptic feedback setting
                                onToggleVibrateEverySecond = appStorage.vibrateEverySecond
                            )

                            1 -> SettingsScreen(card = appStorage.card,
                                timerTicks = appStorage.timerTicks,
                                vibrationIntensity = appStorage.vibrationIntensity,
                                onChangeTimer = { appStorage.timerTicks = it },
                                onChangeCard = { appStorage.card = it },
                                onChangeVibrationIntensity = { appStorage.vibrationIntensity = it },
                                onToggleHaptic = appStorage.haptic,
                                onToggleHapticAction = { appStorage.haptic = it },
                                onToggleVibrateEverySecond = appStorage.vibrateEverySecond,
                                onToggleVibrateEverySecondAction = { appStorage.vibrateEverySecond = it }
                            )

                            else -> throw IllegalArgumentException("Unknown page")
                        }
                    }
                }
            }
        }
    }
}
