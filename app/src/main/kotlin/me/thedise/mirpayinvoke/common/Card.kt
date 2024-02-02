package me.thedise.mirpayinvoke.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import me.thedise.mirpayinvoke.R

enum class Card(
    val colorId: Long,
    @StringRes val titleId: Int,
    @DrawableRes val imageId: Int,
) {

    DEFAULT(
        titleId = R.string.card_secret_garden,
        imageId = R.drawable.card_secret_garden,
        colorId = 0xFF0f9f5a
    ),

    SWISS_PLUM(
        titleId = R.string.card_swiss_plum,
        imageId = R.drawable.card_swiss_plum,
        colorId = 0xFF594fb2
    ),

    LIGHT_CORAL(
        titleId = R.string.card_light_coral,
        imageId = R.drawable.card_light_coral,
        colorId = 0xFFf08080
    ),

    POPPY_POMPADOUR(
        titleId = R.string.card_poppy_pompadour,
        imageId = R.drawable.card_poppy_pompadour,
        colorId = 0xFF6b3fa0
    ),

    SPICED_NECTARINE(
        titleId = R.string.card_spiced_nectarine,
        imageId = R.drawable.card_spiced_nectarine,
        colorId = 0xFFffb872
    ),

    STARGATE_SHIMMER(
        titleId = R.string.card_stargate_shimmer,
        imageId = R.drawable.card_stargate_shimmer,
        colorId = 0xFF6f7dff
    ),

    VEGA_VIOLET(
        titleId = R.string.card_vega_violet,
        imageId = R.drawable.card_vega_violet,
        colorId = 0xFFaa55ff
    ),

    WONDER_LUST(
        titleId = R.string.card_wonder_lust,
        imageId = R.drawable.card_wonder_lust,
        colorId = 0xFFef949d
    ),

    ALPHA(
        titleId = R.string.card_alpha_title,
        imageId = R.drawable.card_alpha_image,
        colorId = 0xFFfd2d3b
    ),

    ROSBANK(
        titleId = R.string.card_rosbank_title,
        imageId = R.drawable.card_rosbank_image,
        colorId = 0xFF9030a9
    ),

    SBERBANK(
        titleId = R.string.card_sberbank_title,
        imageId = R.drawable.card_sber_image,
        colorId = 0xFF50bb5a
    ),

    TINKOFF(
        titleId = R.string.card_tinkoff_title,
        imageId = R.drawable.card_tinkoff_image,
        colorId = 0xFFffde34
    ),

    PSB(
        titleId = R.string.card_psb_title,
        imageId = R.drawable.card_psb_image,
        colorId = 0xFFea5616
    ),


}
