package me.thedise.mirpayinvoke.main

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import me.thedise.mirpayinvoke.common.AppStorage
import me.thedise.mirpayinvoke.common.Nfc
import me.thedise.mirpayinvoke.common.PREFS_NAME
import me.thedise.mirpayinvoke.ui.WearApp
import me.thedise.mirpayinvoke.ui.theme.MirPayTheme

class MainActivity : ComponentActivity() {
    private val appStorage by lazy {
        AppStorage(sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE))
    }

    private var nfc : Nfc? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        nfc = Nfc(this);
        installSplashScreen()
        nfc!!.tryEnableNfc();

        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        setContent {
            MirPayTheme {
                WearApp(appStorage = appStorage, context = this@MainActivity, onTimerEnd = {
                    finish() }, nfc = nfc)
            }
        }
    }

    override fun onDestroy() {
        nfc!!.tryDisableNfc();
        super.onDestroy()
        finish()
    }
}