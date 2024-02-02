package me.thedise.mirpayinvoke.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.thedise.mirpayinvoke.common.AppStorage
import me.thedise.mirpayinvoke.common.PREFS_NAME
import me.thedise.mirpayinvoke.settings.widgets.SettingsScreen

class SettingsActivity : ComponentActivity() {

    private val appStorage by lazy {
        AppStorage(sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SettingsScreen(
                timerTicks = appStorage.timerTicks,
                card = appStorage.card,
                onChangeTimer = { appStorage.timerTicks = it },
                onChangeCard = { appStorage.card = it },
            )
        }
    }
}
