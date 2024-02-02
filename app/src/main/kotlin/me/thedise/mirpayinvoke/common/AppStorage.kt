package me.thedise.mirpayinvoke.common

import android.content.SharedPreferences

class AppStorage(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val TIMER_KEY = "timer"
        private const val CARD_KEY = "card"
    }

    var timerTicks: Int
        get() = sharedPreferences.getInt(TIMER_KEY, DEFAULT_TIMER)
        set(value) = sharedPreferences.edit().putInt(TIMER_KEY, value).apply()

    var card: Card
        get() = Card.valueOf(sharedPreferences.getString(CARD_KEY, Card.DEFAULT.name) ?: Card.DEFAULT
            .name)
        set(value) = sharedPreferences.edit().putString(CARD_KEY, value.name).apply()
}
