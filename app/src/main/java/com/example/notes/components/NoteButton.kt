package com.example.notes.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteButton(
    modifier: Modifier=Modifier,
    value:String,
    enabled:Boolean=true,
    onClick:() -> Unit,
){
    Button(onClick = onClick, shape = CircleShape, modifier = modifier, enabled = enabled) {
        Text(text = value)
    }
}