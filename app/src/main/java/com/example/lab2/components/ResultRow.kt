package com.example.lab2.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
 fun ResultRow(isK: Boolean, element: String, result: Double?){
    val mainText: String = if (isK)  "Показник емісії твердих частинок при спалюванні " else "Валовий викид при спалюванні "
    Box (modifier = Modifier.padding(6.dp)){
        Text(
            buildAnnotatedString {
                append(mainText)
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                    append(element)
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(" = $result")
                }
            })
    }
}