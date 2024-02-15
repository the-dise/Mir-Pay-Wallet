package me.thedise.mirpayinvoke.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import me.thedise.mirpayinvoke.R

@Composable
fun LogoBlock(
    style: TextStyle = MaterialTheme.typography.body2
) {
    Icon(
        modifier = Modifier
            .size(20.dp)
            .wrapContentSize(align = Alignment.Center),
        painter = painterResource(R.drawable.ic_wallet_24),
        contentDescription = null
    )

    Spacer(modifier = Modifier.width(4.dp))

    Text(
        text = stringResource(id = R.string.app_title_mir),
        style = style,
        fontWeight = FontWeight.Medium,
    )

    Spacer(modifier = Modifier.width(1.dp))

    Text(
        text = stringResource(id = R.string.app_title_pay), style = style
    )
}
