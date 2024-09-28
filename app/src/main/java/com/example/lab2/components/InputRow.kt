package com.example.lab2.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp


@Composable
fun InputRow(
    textValue: String,
    baseText: String,
    upperIndexText: String,
    lowerIndexText: String = "",
    onValueChange: (String) -> Unit
) {
    Box(modifier = Modifier.width(120.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextWithIndex(
                baseText = baseText,
                upperIndexText = upperIndexText,
                lowerIndexText = lowerIndexText
            )
            Text(text = "=")

            TextField(value = textValue, onValueChange = { newValue -> onValueChange(newValue) })


        }

    }
}