package com.example.tp3parcial.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.tp3parcial.R


@Composable
fun AppLogo(width: Dp) {
    val aspectRatio = 34f / 135f
    val layerHeight = width * aspectRatio
    val totalHeight = layerHeight * 3f  // three stacked layers with offset

    Box(
        modifier = Modifier
            .width(width)
            .height(totalHeight),
        contentAlignment = Alignment.TopStart,
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle_5),
            contentDescription = null,
            modifier = Modifier
                .width(width)
                .height(layerHeight)
                .offset(x = layerHeight * .6f, y = layerHeight * .8f),
        )

        Image(
            painter = painterResource(id = R.drawable.rectangle_4),
            contentDescription = null,
            modifier = Modifier
                .width(width)
                .height(layerHeight)
                .offset(x = layerHeight * .3f, y = layerHeight * 0.4f),
        )

        Image(
            painter = painterResource(id = R.drawable.rectangle_3),
            contentDescription = null,
            modifier = Modifier
                .width(width)
                .height(layerHeight),
        )
    }
}