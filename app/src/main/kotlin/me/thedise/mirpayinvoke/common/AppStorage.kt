package me.thedise.mirpayinvoke.common

import android.content.SharedPreferences

class AppStorage(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val TIMER_KEY = "timer"
        private const val CARD_KEY = "card"
        private const val HAPTIC_KEY = "haptic"
        private const val VIBRATION_INTENSITY_KEY = "vibration_intensity"
    }

    var timerTicks: Int
        get() = sharedPreferences.getInt(TIMER_KEY, DEFAULT_TIMER)
        set(value) = sharedPreferences.edit().putInt(TIMER_KEY, value).apply()

    var card: Card
        get() = try {
            Card.valueOf(sharedPreferences.getString(CARD_KEY, Card.DEFAULT.name) ?: Card.DEFAULT.name)
        } catch (e: IllegalArgumentException) {
            Card.DEFAULT
        }
        set(value) = sharedPreferences.edit().putString(CARD_KEY, value.name).apply()

    var haptic: Boolean // Getter and setter for haptic feedback setting
        get() = sharedPreferences.getBoolean(HAPTIC_KEY, DEFAULT_HAPTIC) // Default is true
        set(value) = sharedPreferences.edit().putBoolean(HAPTIC_KEY, value).apply()

    var vibrationIntensity: Int
        get() = sharedPreferences.getInt(VIBRATION_INTENSITY_KEY, DEFAULT_VIBRATION_INTENSITY)
        set(value) = sharedPreferences.edit().putInt(VIBRATION_INTENSITY_KEY, value).apply()
}
