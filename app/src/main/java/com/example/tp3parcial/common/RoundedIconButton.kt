package com.example.tp3parcial.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3parcial.R
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun RoundedIconButton(
    onClick: () -> Unit,
    painter: Painter,
    contentDescription: String,
    background: Color = MaterialTheme.colorScheme.surfaceVariant,
    tint: Color = LocalContentColor.current,
    size: Dp = 48.dp,
    iconOffset: DpOffset = DpOffset(0.dp, 0.dp)
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(background)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            tint = tint,
            contentDescription = contentDescription,
            modifier = Modifier.offset(iconOffset.x, iconOffset.y)
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
fun RoundedCloseButtonVariant(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        background = Color(0xFF0B390F),
        painter = painterResource(R.drawable.close),
        contentDescription = "Close",
        tint = Color(0xFF7BF179)
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

@Composable
fun RoundedProfileButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.avatar_placeholder),
        contentDescription = "Profile",
        background = Color(0xFFFCF8F8),
        size = 24.dp
    )
}

@Composable
fun RoundedNotificationButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.notifications),
        contentDescription = "Notifications",
        background = Color.Transparent
    )
}

@Composable
fun RoundedChevronButton(onClick: () -> Unit) {
    RoundedIconButton(
        onClick = onClick,
        painter = painterResource(R.drawable.chevron_right),
        size = 24.dp,
        contentDescription = "",
        background = Color.Transparent,
        iconOffset = DpOffset(1.dp, .5.dp),
    )
}

@Composable
fun RoundedAvatarPlaceholderButton(initials: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(39.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(color = Color(0xFFFCF8F8))
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = initials,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = .5.sp
            )

        }
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(color = Color(0xFF454745))
                .align(Alignment.BottomEnd)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.add_a_photo),
                contentDescription = "Take a picture",
                tint = Color.White,

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedAvatarPlaceholderButtonPreview() {
    AppTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            RoundedAvatarPlaceholderButton(initials = "KB", onClick = {})
            RoundedChevronButton(onClick = {})
        }
    }
}