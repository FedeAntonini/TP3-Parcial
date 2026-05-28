package com.example.tp3parcial.auth.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.R
import com.example.tp3parcial.ui.theme.AppTheme


@Composable
fun IdVerificationView(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Text(
            text = "Let's scan your ID",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Always keep your phone in portrait mode, and here are some more tips.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .aspectRatio(393f/357f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.id_card_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )

            Image(
                painter = painterResource(id = R.drawable.id_card),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.Center)
                    .padding(horizontal = 48.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            // 2. SVG icon — absolutely positioned
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(361f/230f)
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                drawRoundRect(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF8FFF85),
                            Color(0xFF39A0FF)
                        ),
                        start = Offset(size.width / 2, 0f),
                        end = Offset(size.width / 2, size.height)
                    ),
                    cornerRadius = CornerRadius(x = 28.dp.toPx(), y = 28.dp.toPx()), // Corner/Large is typically 28dp
                    style = Stroke(width = 4.dp.toPx())
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun IdVerificationPreview() {
    AppTheme {
        IdVerificationView()
    }
}
