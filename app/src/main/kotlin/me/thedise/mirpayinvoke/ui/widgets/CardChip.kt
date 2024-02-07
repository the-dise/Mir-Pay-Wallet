package me.thedise.mirpayinvoke.ui.widgets

import android.app.RemoteInput
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.CardDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import androidx.wear.input.RemoteInputIntentHelper
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card

private const val CARD_KEY = "card"

fun ScalingLazyListScope.cardChip(
    currentCard: Card,
    onChangeCard: (Card) -> Unit
) = item {
    var newCard by remember { mutableStateOf(currentCard) }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.let { data ->
                val results = RemoteInput.getResultsFromIntent(data)
                newCard = Card.valueOf(results.getString(CARD_KEY) ?: Card.DEFAULT.name)
                onChangeCard(newCard)
            }
        }

    val label = stringResource(R.string.settings_choose_card)

    TitleCard(
        onClick = { launcher.launch(createIntent(label)) },
        title = { Text(text = label) },
        backgroundPainter = CardDefaults.imageWithScrimBackgroundPainter(
            backgroundImagePainter = painterResource(id = newCard.backgroundId),

            ),
        contentColor = MaterialTheme.colors.onSurface,
        titleColor = MaterialTheme.colors.onSurface
    ) {
        Text(stringResource(newCard.titleId))
    }
}

private fun createIntent(label: String) = RemoteInputIntentHelper.putRemoteInputsExtra(
    intent = RemoteInputIntentHelper.createActionRemoteInputIntent(),
    remoteInputs = listOf(
        RemoteInput
            .Builder(CARD_KEY)
            .setLabel(label)
            .setAllowFreeFormInput(false)
            .setChoices(Card.entries.map { it.name }.toTypedArray())
            .build()
    )
)
