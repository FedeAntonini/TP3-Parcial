package com.example.tp3parcial.manage.components

import android.graphics.SweepGradient
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.toColorInt
import com.example.tp3parcial.R
import com.example.tp3parcial.ui.theme.AppTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ManageCreditScoreView(
    score: Int,
    scoreLabel: String,
    modifier: Modifier = Modifier,
    minScore: Int = 300,
    maxScore: Int = 850
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = "Credit score",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier,
            ) {
                GaugeArc(score = score, minScore = minScore, maxScore = maxScore)
                GaugeNeedle(score = score, minScore = minScore, maxScore = maxScore)
            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = score.toString(),
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = buildAnnotatedString {
                    append("Your Score is ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(scoreLabel)
                    }
                },
                style = MaterialTheme.typography.bodyLarge
            )
        }
        HorizontalDivider(color = Color(0xFFE5E2E1))
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "What is Credit Score?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = "This is your trust score, used as a bases to determine the various activities you do on Credit Score.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
fun GaugeArc(score: Int, minScore: Int, maxScore: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current // get this OUTSIDE the Canvas block
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
                .padding(horizontal = 12.dp)
        ) {
            val strokeWidth = 14.dp.toPx()
            val arcSize = Size(size.width - strokeWidth, size.width - strokeWidth)
            val topLeft = Offset(strokeWidth / 2, strokeWidth / 2)
            val center = Offset(size.width / 2, size.height)
            val labelPaint = android.graphics.Paint().apply {
                textSize = 22.dp.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
                color = android.graphics.Color.GRAY
                typeface = ResourcesCompat.getFont(context, R.font.montserrat_bold)
            }
            val gradientBrush = ShaderBrush(
                SweepGradient(
                    center.x, center.y,
                    intArrayOf(
                        "#E53935".toColorInt(),
                        "#E53935".toColorInt(),
                        "#FF7043".toColorInt(),
                        "#FFA726".toColorInt(),
                        "#FFEE58".toColorInt(),
                        "#9CCC65".toColorInt(),
                        "#43A047".toColorInt(),
                        "#43A047".toColorInt(),
                    ),
                    floatArrayOf(0f, 0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 1.0f)
                ).apply {
                    val matrix = android.graphics.Matrix()
                    matrix.setRotate(180f, center.x, center.y)
                    setLocalMatrix(matrix)
                }
            )

            drawArc(
                brush = gradientBrush,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = topLeft,
                size = arcSize
            )

            val dashInset = strokeWidth * -2f
            val dashRect = Rect(
                Offset(topLeft.x - dashInset / 2, topLeft.y - dashInset / 2),
                Size(arcSize.width + dashInset, arcSize.height + dashInset)
            )

            val dashPaint = Paint().apply {
                style = PaintingStyle.Stroke
                this.strokeWidth = 1.dp.toPx()
                color = Color(0xFFCCCCCC)
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(48f, 48f)) // larger dashes
            }
            drawContext.canvas.drawArc(
                rect = dashRect,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                paint = dashPaint
            )

            drawContext.canvas.nativeCanvas.drawText(
                minScore.toString(),
                strokeWidth / 2,
                size.height + 20.dp.toPx(),
                labelPaint
            )
            drawContext.canvas.nativeCanvas.drawText(
                maxScore.toString(),
                size.width - strokeWidth / 2,
                size.height + 20.dp.toPx(),
                labelPaint
            )
        }
    }
}

@Composable
fun GaugeNeedle(score: Int, minScore: Int, maxScore: Int) {
    val fraction = (score - minScore).toFloat() / (maxScore - minScore).toFloat()
    val angle = 180f * fraction // 0° = left, 180° = right

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .padding(horizontal = 24.dp, 24.dp)
    ) {
        val centerX = size.width / 2
        val centerY = size.height
        val needleLength = size.height * .8f

        val radians = Math.toRadians((180f - angle).toDouble())
        val needleTipX = centerX + (needleLength * cos(radians)).toFloat()
        val needleTipY = centerY - (needleLength * sin(radians)).toFloat()

        // Needle line
        drawLine(
            color = Color.Black,
            start = Offset(centerX, centerY),
            end = Offset(needleTipX, needleTipY),
            strokeWidth = 3.dp.toPx(),
            cap = StrokeCap.Round
        )

        // Center dot
        drawCircle(
            color = Color.Black,
            radius = 6.dp.toPx(),
            center = Offset(centerX, centerY)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ManageCreditScoreViewPreview() {
    AppTheme {
        ManageCreditScoreView(
            score = 720,
            scoreLabel = "Good",
            minScore = 300,
            maxScore = 850,
        )
    }
}