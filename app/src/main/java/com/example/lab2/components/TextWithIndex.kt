package com.example.lab2.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextWithIndex(baseText: String, upperIndexText: String, lowerIndexText: String = "") {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = baseText,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        if (upperIndexText.isNotEmpty()) {
            Text(
                text = upperIndexText,
                fontSize = 12.sp,
                modifier = Modifier.offset(y = (-4).dp)
            )
        }
        if (lowerIndexText.isNotEmpty()) {
            Text(
                text = lowerIndexText,
                fontSize = 12.sp,
                modifier = Modifier.offset(y = 4.dp)
            )
        }
    }
}