package com.example.lab2.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

@Composable
fun MainButton(onClick: () -> Unit, buttonText: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            colors = ButtonColors(
                containerColor = Color.Yellow.copy(alpha = 0.5f),
                contentColor = Color.Black,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Yellow
            ),
            onClick = onClick,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = buttonText)
        }
    }
}
