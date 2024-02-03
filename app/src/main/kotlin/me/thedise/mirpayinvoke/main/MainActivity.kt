package me.thedise.mirpayinvoke.main

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.thedise.mirpayinvoke.common.AppStorage
import me.thedise.mirpayinvoke.common.Card
import me.thedise.mirpayinvoke.common.PREFS_NAME
import me.thedise.mirpayinvoke.main.widgets.MirPayScreen

class MainActivity : ComponentActivity() {

    private val appStorage by lazy {
        AppStorage(sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContent {
            MirPayScreen(
                maxTicks = appStorage.timerTicks,
                card = appStorage.card,
                onTimerEnd = { finish() }
            )
        }
    }
}

@Preview(
    device = "id:wearos_small_round",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_WATCH
)
@Composable
fun MainActivityScreenPreview() {
    MirPayScreen(maxTicks = 15, card = Card.SPICED_NECTARINE) {}
}