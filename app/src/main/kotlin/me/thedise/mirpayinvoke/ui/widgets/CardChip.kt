package me.thedise.mirpayinvoke.ui.widgets

import android.app.RemoteInput
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card

private const val CARD_KEY = "card"

fun ScalingLazyListScope.cardChip(
    currentCard: Card, onChangeCard: (Card) -> Unit
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

    Chip(modifier = Modifier.fillMaxWidth(),
        onClick = { launcher.launch(createIntent(label)) },
        label = {
            Text(
                text = stringResource(id = R.string.settings_card_title), maxLines = 1
            )
        },
        secondaryLabel = {
            Text(
                text = stringResource(newCard.titleId), maxLines = 1
            )
        },
        colors = ChipDefaults.secondaryChipColors(),
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_card_24),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .wrapContentSize(align = Alignment.Center),
                tint = MaterialTheme.colors.primary
            )
        })

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
