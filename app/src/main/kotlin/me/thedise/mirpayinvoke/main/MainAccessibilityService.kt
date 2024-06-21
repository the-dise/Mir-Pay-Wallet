package me.thedise.mirpayinvoke.main

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Intent
import android.view.accessibility.AccessibilityEvent


class MainAccessibilityService : AccessibilityService() {
    @SuppressLint("WearRecents")
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event != null) {
            if (event.packageName?.equals("com.google.android.apps.walletnfcrel")!!) {
                val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager;
                performGlobalAction(GLOBAL_ACTION_BACK);
                manager.killBackgroundProcesses(event.packageName.toString());
                val intent = packageManager.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent);
                };
            }
        }
    }

    override fun onInterrupt() {

    }
}