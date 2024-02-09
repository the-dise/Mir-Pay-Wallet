package me.thedise.mirpayinvoke.main

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import me.thedise.mirpayinvoke.common.AppStorage
import me.thedise.mirpayinvoke.common.PREFS_NAME
import me.thedise.mirpayinvoke.ui.WearApp

class MainActivity : ComponentActivity() {

    private val appStorage by lazy {
        AppStorage(sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContent {
            WearApp(appStorage = appStorage, onTimerEnd = { finish() })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}