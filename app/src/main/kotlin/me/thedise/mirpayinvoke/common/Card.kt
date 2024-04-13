package me.thedise.mirpayinvoke.common

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import me.thedise.mirpayinvoke.R

enum class Card(
    @ColorInt val colorId: Long, @StringRes val titleId: Int, @DrawableRes val imageId: Int
) {

    DEFAULT(
        titleId = R.string.card_default_secret_garden,
        imageId = R.drawable.card_default_secret_garden,
        colorId = 0xFF0F9F5A
    ),

    SWISS_PLUM(
        titleId = R.string.card_default_swiss_plum,
        imageId = R.drawable.card_default_swiss_plum,
        colorId = 0xFF594FB2
    ),

    LIGHT_CORAL(
        titleId = R.string.card_default_light_coral,
        imageId = R.drawable.card_default_light_coral,
        colorId = 0xFFF08080
    ),

    SPICED_NECTARINE(
        titleId = R.string.card_default_spiced_nectarine,
        imageId = R.drawable.card_default_spiced_nectarine,
        colorId = 0xFFFFB872
    ),

    STARGATE_SHIMMER(
        titleId = R.string.card_default_stargate_shimmer,
        imageId = R.drawable.card_default_stargate_shimmer,
        colorId = 0xFF6F7DFF
    ),

    VEGA_VIOLET(
        titleId = R.string.card_default_vega_violet,
        imageId = R.drawable.card_default_vega_violet,
        colorId = 0xFFAA55FF
    ),

    WONDER_LUST(
        titleId = R.string.card_default_wonder_lust,
        imageId = R.drawable.card_default_wounder_list,
        colorId = 0xFFEF949D
    ),

    ALPHA(
        titleId = R.string.card_real_alpha_title,
        imageId = R.drawable.card_real_alpha,
        colorId = 0xFFFD2D3B
    ),

    ROSBANK(
        titleId = R.string.card_real_rosbank_title,
        imageId = R.drawable.card_real_rosbank,
        colorId = 0xFF9030A9
    ),

    SBERBANK(
        titleId = R.string.card_real_sberbank_title,
        imageId = R.drawable.card_real_sber,
        colorId = 0xFF50BB5A
    ),

    TINKOFF_BLACK(
        titleId = R.string.card_real_tinkoff_title,
        imageId = R.drawable.card_real_tinkoff_black,
        colorId = 0xFFFFDE34
    ),
    TINKOFF_DRIVE(
        titleId = R.string.card_real_tinkoff_drive_title,
        imageId = R.drawable.card_real_tinkoff_drive,
        colorId = 0xFFFFDE34
    ),
    TINKOFF_PREMIUM(
        titleId = R.string.card_real_tinkoff_premium_title,
        imageId = R.drawable.card_real_tinkoff_premium,
        colorId = 0xFFFFDE34
    ),
    TINKOFF_PLATINUM(
        titleId = R.string.card_real_tinkoff_platinum_title,
        imageId = R.drawable.card_real_tinkoff_platinum,
        colorId = 0xFFFFDE34
    ),

    TINKOFF_INVEST_BEAR(
        titleId = R.string.card_real_tinkoff_invest_bear_title,
        imageId = R.drawable.card_real_tinkoff_invest_bear,
        colorId = 0xFFFFDE34
    ),

    PSB(
        titleId = R.string.card_real_psb_title,
        imageId = R.drawable.card_real_psb,
        colorId = 0xFFEA5616
    ),

    GAZPROMBANK(
        titleId = R.string.card_real_gazprombank_title,
        imageId = R.drawable.card_real_gazprombank,
        colorId = 0xFFF58128
    ),

    RSHB(
        titleId = R.string.card_real_rshb_title,
        imageId = R.drawable.card_real_rshb,
        colorId = 0xFFFFD108
    ),

    RAIFFEISEN(
        titleId = R.string.card_real_raiffeisen_title,
        imageId = R.drawable.card_real_raiffeisen,
        colorId = 0xFFFEE600
    ),

    URALSIB(
        titleId = R.string.card_real_uralsib_title,
        imageId = R.drawable.card_real_uralsib,
        colorId = 0xFF4B226B
    ),

    VTB(
        titleId = R.string.card_real_vtb_title,
        imageId = R.drawable.card_real_vtb,
        colorId = 0xFF0058B9
    ),

    YANDEX(
        titleId = R.string.card_real_yandex_title,
        imageId = R.drawable.card_real_yandex,
        colorId = 0xFFD049A7
    ),

    PRIMBANK(
        titleId = R.string.card_real_primbank_title,
        imageId = R.drawable.card_real_primbank,
        colorId = 0xFF00928F
    ),


}
