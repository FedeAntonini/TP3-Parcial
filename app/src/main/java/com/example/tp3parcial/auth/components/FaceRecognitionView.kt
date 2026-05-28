package com.example.tp3parcial.auth.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun FaceRecognitionView(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Text(
            text = "Put your face in the\nframe",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Follow these instructions, and let us get you onboarded.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .height(357.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.face_recognition_image), // your image asset
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )

            // 2. SVG icon — absolutely positioned
            Canvas(
                modifier = Modifier
                    .size(150.dp, 190.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 56.dp)
            ) {
                drawOval(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF8FFF85),
                            Color(0xFF39A0FF)
                        ),
                        start = Offset(size.width / 2, 0f),
                        end = Offset(size.width / 2, size.height)
                    ),
                    style = Stroke(width = 4.dp.toPx())
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FaceRecognitionPreview() {
    AppTheme {
        FaceRecognitionView()
    }
}
