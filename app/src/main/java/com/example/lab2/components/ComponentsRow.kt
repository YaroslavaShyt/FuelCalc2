package com.example.lab2.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.lab2.Type

@Composable
fun ComponentsRow(
    onQValChanged: (String, Type) -> Unit,
    onaValChanged: (String, Type) -> Unit,
    onAValChanged: (String, Type) -> Unit,
    onGValChanged: (String, Type) -> Unit,
    onnValChanged: (String, Type) -> Unit,
    qValue: String,
    aValue: String,
    arValue: String,
    gValue: String,
    nValue: String,
    type: Type = Type.Coal
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        InputRow(
            textValue = qValue,
            baseText = "Q",
            upperIndexText = "r",
            lowerIndexText = "i",
            onValueChange = { onQValChanged(it, type) }
        )
        Box(modifier = Modifier.padding(5.dp))

        InputRow(
            textValue = aValue,
            baseText = "a",
            upperIndexText = "",
            lowerIndexText = "вин",
            onValueChange = { onaValChanged(it, type) }
        )
        Box(modifier = Modifier.padding(5.dp))

        InputRow(
            textValue = arValue,
            baseText = "А",
            upperIndexText = "r",
            lowerIndexText = "",
            onValueChange = { onAValChanged(it, type) }
        )
    }
    Box(modifier = Modifier.padding(10.dp))
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        InputRow(
            textValue = gValue,
            baseText = "Г",
            upperIndexText = "",
            lowerIndexText = "вин",
            onValueChange = { onGValChanged(it, type) }
        )
        Box(modifier = Modifier.padding(5.dp))

        InputRow(
            textValue = nValue,
            baseText = "η",
            upperIndexText = "",
            lowerIndexText = "ду",
            onValueChange = { onnValChanged(it, type) }
        )
    }
}

