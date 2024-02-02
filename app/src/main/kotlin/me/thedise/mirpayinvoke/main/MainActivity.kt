package me.thedise.mirpayinvoke.main

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.thedise.mirpayinvoke.common.AppStorage
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
