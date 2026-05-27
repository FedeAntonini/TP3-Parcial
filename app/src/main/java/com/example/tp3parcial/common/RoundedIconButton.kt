package com.example.tp3parcial.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.R

@Composable
fun RoundedIconButton(
    onClick: () -> Unit,
    painter: Painter,
    contentDescription: String,
    background: Color = MaterialTheme.colorScheme.surfaceVariant
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(background)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(R.drawable.arrow_back),
            contentDescription = "Back"
        )
    }
}

@Composable
fun RoundedBackButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.arrow_back),
        contentDescription = "Back"
    )
}

@Composable
fun RoundedCloseButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.close),
        contentDescription = "Close"
    )
}

@Composable
fun RoundedInfoButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.info),
        contentDescription = "Info",
        background = Color.Transparent
    )
}

@Composable
fun RoundedMoreVertButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.more_vert),
        contentDescription = "More options",
        background = Color.Transparent
    )
}

@Composable
fun RoundedMoreHoriButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.more_hori),
        contentDescription = "More options",
        background = Color.Transparent
    )
}
