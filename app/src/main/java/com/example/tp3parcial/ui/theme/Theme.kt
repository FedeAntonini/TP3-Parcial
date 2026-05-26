package com.example.tp3parcial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ── Light colour scheme ───────────────────────────────────────────────────────
private val LightColorScheme = lightColorScheme(
    // Brand / interactive
    primary            = InteractivePrimary,       // #163300  dark forest green
    onPrimary          = BaseContrast,             // #FFFFFF
    primaryContainer   = BackgroundNeutral,        // #E5F5EA  soft green tint
    onPrimaryContainer = ContentPrimary,           // #122300

    secondary          = InteractiveAccent,        // #7BF179  vivid green
    onSecondary        = BaseDark,                 // #121511
    secondaryContainer = BackgroundNeutral,        // #E5F5EA
    onSecondaryContainer = ContentPrimary,         // #122300

    tertiary           = InteractiveSecondary,     // #868685  neutral grey
    onTertiary         = BaseContrast,             // #FFFFFF
    tertiaryContainer  = BackgroundNeutral,        // #E5F5EA
    onTertiaryContainer = ContentPrimary,          // #122300

    // Surfaces
    background         = BackgroundScreen,         // #FFFFFF
    onBackground       = ContentPrimary,           // #122300

    surface            = BackgroundScreen,         // #FFFFFF
    onSurface          = ContentPrimary,           // #122300
    surfaceVariant     = BackgroundNeutral,        // #E5F5EA
    onSurfaceVariant   = ContentSecondary,         // #454745

    // Overlays / outlines
    outline            = BorderNeutral,            // #0E0F0C @ 12%
    outlineVariant     = BorderOverlay,

    // Errors (sentiment negative)
    error              = SentimentNegativeVibrant, // #A8200D
    onError            = BaseContrast,             // #FFFFFF
    errorContainer     = Color(0xFFFFF0EE),        // light tint of error
    onErrorContainer   = SentimentNegativeVibrant,

    // Inverse / scrim
    inverseSurface     = BaseDark,                 // #121511
    inverseOnSurface   = BaseContrast,             // #FFFFFF
    inversePrimary     = InteractiveAccent,        // #7BF179
    scrim              = BaseDark,
)

// ── Dark colour scheme ────────────────────────────────────────────────────────
private val DarkColorScheme = darkColorScheme(
    primary            = InteractiveAccent,        // #7BF179  bright on dark
    onPrimary          = BaseDark,                 // #121511
    primaryContainer   = InteractivePrimary,       // #163300
    onPrimaryContainer = InteractiveAccent,        // #7BF179

    secondary          = InteractiveContrast,      // #7BF179
    onSecondary        = BaseDark,
    secondaryContainer = InteractivePrimary,
    onSecondaryContainer = InteractiveAccent,

    tertiary           = ContentTertiary,          // #6A6C6A
    onTertiary         = BaseContrast,
    tertiaryContainer  = ContentSecondary,         // #454745
    onTertiaryContainer = BaseContrast,

    background         = BaseDark,                 // #121511
    onBackground       = BaseContrast,             // #FFFFFF

    surface            = BaseDark,                 // #121511
    onSurface          = BaseContrast,
    surfaceVariant     = ContentPrimary,           // #122300  very dark green
    onSurfaceVariant   = ContentTertiary,          // #6A6C6A

    outline            = ContentSecondary,         // #454745
    outlineVariant     = ContentTertiary,

    error              = SentimentNegativeVibrant, // #A8200D
    onError            = BaseContrast,
    errorContainer     = Color(0xFF690005),
    onErrorContainer   = Color(0xFFFFDAD6),

    inverseSurface     = BaseContrast,
    inverseOnSurface   = BaseDark,
    inversePrimary     = InteractivePrimary,
    scrim              = BaseDark,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = AppTypography,
        content     = content,
    )
}