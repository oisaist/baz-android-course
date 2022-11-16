package com.wizelinebootcamp.bitcoinapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

/*
*       Color primary is for containers. Example: Button containers -> Primary colors is used for toolbar and floating button
*       Color primary variant should be more dark than primary
*       Color onPrimary is for text and icons on buttons
* */

    /* Secondary colors are best for:
    * Floating action buttons
    * Selection controls, like sliders and switches
    * Highlighting selected text
    * Progress bars
    * Links and headlines
    */

    /*
    Surface colors affect surfaces of components, such as cards, sheets, and menus.
    */

    /*
    * The background color appears behind scrollable content. The baseline background and surface color is #FFFFFF.
    * */

    /*
    * Error color indicates errors in components, such as invalid text in a text field. The baseline error color is #B00020.
    * */

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = WhiteColor,
    onPrimary = BlackColor,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Gray50,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BitCoinAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = QuickSand,
        shapes = Shapes,
        content = content
    )
}
