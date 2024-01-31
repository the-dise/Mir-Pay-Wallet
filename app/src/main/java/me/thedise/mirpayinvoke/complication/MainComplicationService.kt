package me.thedise.mirpayinvoke.complication

import android.app.PendingIntent
import android.content.Intent
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.ShortTextComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import me.thedise.mirpayinvoke.presentation.MainActivity

/**
 * Skeleton for complication data source that returns short text.
 */
class MainComplicationService : SuspendingComplicationDataSourceService() {

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        if (type != ComplicationType.SHORT_TEXT) {
            return null
        }
        return createComplicationData("Pay", "Mir Pay")
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData {
        // Replace dynamic day of the week with static text
        val staticText = "Pay"
        val staticTextLong = "Mir Pay"

        // Create ComplicationData with the static text
        return createComplicationData(staticText, staticTextLong)
    }

    private fun createComplicationData(text: String, contentDescription: String): ShortTextComplicationData {
        // Create an intent to open MainActivity
        val intent = Intent(applicationContext, MainActivity::class.java)

        // Create a PendingIntent with the intent
        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Build ComplicationData with the static text and PendingIntent
        return ShortTextComplicationData.Builder(
            text = PlainComplicationText.Builder(text).build(),
            contentDescription = PlainComplicationText.Builder(contentDescription).build()
        )
            .setTapAction(pendingIntent)
            .build()
    }
}