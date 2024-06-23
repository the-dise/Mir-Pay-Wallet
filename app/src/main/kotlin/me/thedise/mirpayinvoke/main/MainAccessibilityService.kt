package me.thedise.mirpayinvoke.main

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.content.Intent
import android.view.accessibility.AccessibilityEvent


class MainAccessibilityService : AccessibilityService() {
    @SuppressLint("WearRecents")
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event != null) {
            if (event.packageName?.equals("com.google.android.apps.walletnfcrel")!!) {
                performGlobalAction(GLOBAL_ACTION_BACK);
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