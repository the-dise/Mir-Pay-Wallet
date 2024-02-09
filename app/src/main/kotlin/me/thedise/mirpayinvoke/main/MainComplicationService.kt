package me.thedise.mirpayinvoke.main

import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Icon
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.MonochromaticImage
import androidx.wear.watchface.complications.data.MonochromaticImageComplicationData
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import me.thedise.mirpayinvoke.R

class MainComplicationService : SuspendingComplicationDataSourceService() {

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        if (type != ComplicationType.MONOCHROMATIC_IMAGE) {
            return null
        }

        return monochromaticImageData()
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(applicationContext, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        return monochromaticImageData(pendingIntent)
    }

    private fun monochromaticImageData(tapAction: PendingIntent? = null): MonochromaticImageComplicationData {
        val monochromaticImageBuilder = MonochromaticImage.Builder(
            image = Icon.createWithResource(
                applicationContext, R.drawable.ic_wallet_24
            )
        )
        val contentDescription =
            PlainComplicationText.Builder(getText(R.string.complication_provider_label)).build()

        return MonochromaticImageComplicationData.Builder(
            monochromaticImageBuilder.build(), contentDescription
        ).setTapAction(tapAction).build()
    }
}
