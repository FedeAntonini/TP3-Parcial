package com.example.tp3parcial.manage.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.R
import com.example.tp3parcial.common.RoundedChevronButton
import com.example.tp3parcial.manage.interfaces.ProfileMenuItem
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun ProfileMenuItemRow(item: ProfileMenuItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { item.onClick() }
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(item.icon),
            contentDescription = item.label,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        RoundedChevronButton(onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileMenuItemRowPreview() {
    AppTheme {
        ProfileMenuItemRow(ProfileMenuItem(
            icon = R.drawable.terms_and_conditions,
            label = "Terms and Conditions",
            onClick = {}
        ))
    }
}