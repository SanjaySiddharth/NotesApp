package com.example.notes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.models.NoteDataModel
import java.time.format.DateTimeFormatter


@Composable
fun NoteCard(
    modifier: Modifier=Modifier,
    note:NoteDataModel,
    onClicked:(NoteDataModel)->Unit,
    
){
    Card(modifier
        .padding(4.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(7.dp)),
        backgroundColor = Color.LightGray) {
        Column(modifier
            .clickable {onClicked(note) }
            .padding(horizontal = 16.dp, vertical = 8.dp), horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle1)
            Text(text = note.description, style = MaterialTheme.typography.subtitle2)
            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE,d MMM")),
            style = MaterialTheme.typography.caption)

        }
    }
}