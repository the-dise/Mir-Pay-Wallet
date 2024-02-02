package me.thedise.mirpayinvoke.main.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import kotlinx.coroutines.delay
import me.thedise.mirpayinvoke.R
import me.thedise.mirpayinvoke.common.Card
import kotlin.time.Duration.Companion.seconds

@Composable
fun MirPayScreen(
    maxTicks: Int,
    card: Card,
    onTimerEnd: () -> Unit,
) {
    var currentTicks by remember { mutableIntStateOf(0) }

    // Google Sans Medium font
    val googleSansMedium = FontFamily(
        Font(R.font.google_sans_medium)
    )
    val googleSansRegular = FontFamily(
        Font(R.font.google_sans_regular)
    )

    LaunchedEffect(Unit) {
        while (currentTicks != maxTicks) {
            delay(1.seconds)
            currentTicks++

            if (currentTicks == maxTicks) {
                onTimerEnd()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(card.colorId), Color.Black),
                    radius = 175f
                )
            )
    ) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.ic_wallet_24),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "Mir",
                fontFamily = googleSansMedium,
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = "Pay",
                fontFamily = googleSansRegular,
            )
        }

        Image(
            modifier = Modifier
                .padding(0.dp, 4.dp, 0.dp, 0.dp)
                .width(172.dp)
                .align(Alignment.Center),
            painter = painterResource(card.imageId),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            /*Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.ic_outline_access_time_24),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(4.dp))*/

            AnimatedCounter(
                count = (maxTicks - currentTicks)
            )
        }
    }
}
