package com.example.tp3parcial.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.common.RoundedBackButton
import com.example.tp3parcial.common.RoundedCloseButton
import com.example.tp3parcial.common.RoundedInfoButton
import com.example.tp3parcial.common.RoundedMoreHoriButton

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    leftComponent: @Composable (() -> Unit)? = null,
    centerComponent: @Composable (() -> Unit)? = null,
    rightComponent: @Composable (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 64.dp)
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Box(modifier = Modifier.sizeIn(minWidth = 48.dp)) {
            leftComponent?.invoke()
        }
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            centerComponent?.invoke()
        }
        Box(modifier = Modifier.sizeIn(minWidth = 48.dp)) {
            rightComponent?.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    Column {
        AppTopBar(
            leftComponent = { BackButton { } }
        )
        HorizontalDivider()
        AppTopBar(
            leftComponent = { RoundedBackButton { } },
            centerComponent = {
                Text("Cash-In", style = MaterialTheme.typography.titleMedium)
            }
        )
        HorizontalDivider()
        AppTopBar(
            leftComponent = { BackButton { } },
            centerComponent = {
                Text("Cash-In", style = MaterialTheme.typography.titleMedium)
            },
            rightComponent = { RoundedInfoButton { } }
        )
        HorizontalDivider()
        AppTopBar(
            leftComponent = { RoundedCloseButton { } },
            rightComponent = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    RoundedInfoButton { }
                    RoundedMoreHoriButton { }
                }
            }
        )
    }
}