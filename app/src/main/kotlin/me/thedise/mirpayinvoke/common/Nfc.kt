package me.thedise.mirpayinvoke.common

import android.content.pm.PackageManager
import android.nfc.NfcAdapter
import androidx.activity.ComponentActivity

class Nfc(
    private val activity: ComponentActivity
) {
    private var nfcHasBeenEnabled : Boolean = false;

    private fun hasSecurePermissions() : Boolean {
        val name = "android.permission.WRITE_SECURE_SETTINGS";
        return activity.checkSelfPermission(name) == PackageManager.PERMISSION_GRANTED;
    }

    private fun canNfcActionDo() : Boolean {
        return getNfcService() != null && hasSecurePermissions();
    }

    private fun getNfcService(): NfcAdapter? {
        return NfcAdapter.getDefaultAdapter(activity.applicationContext);
    }

    fun tryEnableNfc() {
        if(!canNfcActionDo()) return;

        val service = getNfcService()!!;

        if(service.isEnabled) return;
        enable();
        nfcHasBeenEnabled = true;
    }

    private fun callMethod(name: String) {
        try {
            getNfcService()!!.javaClass.getMethod(name).invoke(getNfcService()!!);
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }

    private fun enable() {
        callMethod("enable");
    }

    private fun disable() {
        callMethod("disable");
    }

    fun tryDisableNfc() {
        if(!canNfcActionDo()) return;

        val service = getNfcService()!!;
        if(!nfcHasBeenEnabled) return;

        if(service.isEnabled) disable();
        nfcHasBeenEnabled = false;
    }
}
