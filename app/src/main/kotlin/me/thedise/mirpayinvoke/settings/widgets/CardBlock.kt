@file:Suppress("DEPRECATION")

package me.thedise.mirpayinvoke.settings.widgets

import android.app.RemoteInput
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ScalingLazyListScope
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card

private const val CARD_KEY = "card"

fun ScalingLazyListScope.cardBlock(
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

    DefaultBox(onClick = { launcher.launch(createIntent(label)) }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(newCard.titleId),
                    fontSize = 10.sp,
                )

                Image(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    painter = painterResource(newCard.imageId),
                    contentDescription = null
                )
            }
        }
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
