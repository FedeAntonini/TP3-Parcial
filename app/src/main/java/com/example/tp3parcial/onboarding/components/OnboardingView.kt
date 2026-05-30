package com.example.tp3parcial.onboarding.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.onboarding.data.onboardingPages
import com.example.tp3parcial.onboarding.interfaces.OnboardingPage
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun OnboardingView(
    pages: List<OnboardingPage>,
    onGetStarted: () -> Unit,
    onLogin: () -> Unit,
    onSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val currentPage = pages[pagerState.currentPage]

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
            ) { index ->
                val page = pages[index]
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd

                    ) {
                        Image(
                            painter = painterResource(page.image),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "`",
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(377f / 346f)
                        )
                    }


                    Spacer(modifier = Modifier.height(32.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 120.dp)
                    ) {
                        Text(
                            text = page.title,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = page.subtitle,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }
            }
        }

        DotsIndicator(
            pageCount = pages.size, currentPage = pagerState.currentPage
        )

        if (currentPage.isLast) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(
                    onClick = onLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),

                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(text = "Log In", color = Color.White)
                }
                PillButton(text = "Sign up for free", onClick = onSignUp)
            }
        } else {
            PillButton(text = "Get Started", onClick = onGetStarted)
        }
    }
}

@Composable
fun DotsIndicator(
    pageCount: Int,
    currentPage: Int,
    activeColor: Color = Color(0xFF00C853),   // swap for your green token
    inactiveColor: Color = Color(0xFFB0BEC5)
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(if (index == currentPage) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (index == currentPage) activeColor else inactiveColor)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF002203)
@Composable
fun OnboardingViewPreview() {
    AppTheme {
        OnboardingView(pages = onboardingPages, onLogin = {}, onSignUp = {}, onGetStarted = {})
    }
}